package top.xiaolinz.search.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import cn.hutool.core.map.MapUtil;
import top.xiaolinz.search.mapper.EsRepository;
import top.xiaolinz.search.service.SearchService;
import top.xiaolinz.search_api.entity.SkuInfo;

/**
 * @author XiaoLin
 * @date 2022/3/16 10:25
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ElasticsearchRestTemplate esTemplate;

    @Autowired
    private EsRepository esRepository;

    @Override
    public Map<String, Object> search(Map<String, String> map) {
        final HashMap<String, Object> resMap = new HashMap<>();

        if (MapUtil.isNotEmpty(map)) {
            this.handlerSearchMap(map);
            // 封装查询条件
            final NativeSearchQuery searchQuery = this.retrievalConditionStructure(map);

            final SearchHits<SkuInfo> hits = this.esTemplate.search(searchQuery, SkuInfo.class);
            final long totalHits = hits.getTotalHits();
            final List<SearchHit<SkuInfo>> searchHits = hits.getSearchHits();
            final List<SkuInfo> skuInfos = searchHits.stream().map(searchHit -> {
                final SkuInfo skuInfo = searchHit.getContent();
                if (StringUtils.isNotBlank(map.get("keyword"))) {
                    final List<String> name = searchHit.getHighlightField("name");
                    skuInfo.setName(name.get(0));
                }

                return skuInfo;
            }).collect(Collectors.toList());

            final Aggregations aggregations = hits.getAggregations();
            final ParsedStringTerms brandTerms = aggregations.get("skuBrand");
            final List<? extends Terms.Bucket> buckets = brandTerms.getBuckets();

            final List<String> brandList =
                buckets.stream().map(Terms.Bucket::getKeyAsString).collect(Collectors.toList());

            final ParsedStringTerms skuSpecTerms = aggregations.get("skuSpec");

            final List<? extends Terms.Bucket> termsBuckets = skuSpecTerms.getBuckets();
            final List<String> skuSpecList =
                termsBuckets.stream().map(Terms.Bucket::getKeyAsString).collect(Collectors.toList());

            resMap.put("total", totalHits);
            resMap.put("rows", skuInfos);
            Integer size = Integer.valueOf(map.get("size"));
            long pageSize = (totalHits + size - 1) / size;
            resMap.put("totalPages", pageSize);
            resMap.put("brandList", brandList);
            resMap.put("skuSpecList", skuSpecList);

        }

        return resMap;
    }

    /**
     * 根据条件集构造条件对象
     *
     * @param map
     *            条件集合
     * @return 条件对象
     */
    public NativeSearchQuery retrievalConditionStructure(Map<String, String> map) {

        final NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        final BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        // 根据关键字查询
        if (StringUtils.isNotBlank(map.get("keyword"))) {
            boolQuery.must(QueryBuilders.matchQuery("name", map.get("keyword")).operator(Operator.AND));
        }

        // 根据品牌
        if (StringUtils.isNotBlank(map.get("brand"))) {
            boolQuery.filter(QueryBuilders.termQuery("brandName", map.get("brand")));
        }
        // 根据规格
        for (String key : map.keySet()) {
            if (key.startsWith("spec_")) {
                final String value = map.get(key).replace("%2B", "+");
                boolQuery.filter(QueryBuilders.termQuery("specMap." + key.substring(5) + ".keyword", value));
            }
        }

        // 根据价格进行过滤
        if (StringUtils.isNotBlank(map.get("price"))) {

            final String[] prices = map.get("price").split("-");

            if (prices.length == 2) {
                boolQuery.filter(QueryBuilders.rangeQuery("price").lte(prices[1]));
            }

            boolQuery.filter(QueryBuilders.rangeQuery("price").gte(prices[0]));

        }

        // 分页
        if (StringUtils.isNotBlank(map.get("page")) && StringUtils.isNotBlank(map.get("size"))) {
            final int page = Integer.parseInt(map.get("page"));
            final int size = Integer.parseInt(map.get("size"));
            builder.withPageable(PageRequest.of(page - 1, size));
        }

        // 排序
        if (StringUtils.isNotBlank(map.get("sortField")) && StringUtils.isNotBlank(map.get("sortRule"))) {
            if ("asc".equalsIgnoreCase(map.get("sortRule"))) {
                builder.withSort(SortBuilders.fieldSort(map.get("sortField")).order(SortOrder.ASC));
            } else {
                builder.withSort(SortBuilders.fieldSort(map.get("sortField")).order(SortOrder.DESC));
            }
        }

        if (StringUtils.isNotBlank(map.get("keyword"))) {
            final HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("name");

            highlightBuilder.preTags("<b style='color:red'>");

            highlightBuilder.postTags("</b>");

            builder.withHighlightBuilder(highlightBuilder);
        }

        // 根据品牌聚合
        builder.addAggregation(AggregationBuilders.terms("skuBrand").field("brandName"));

        // 根据规格进行聚合
        builder.addAggregation(AggregationBuilders.terms("skuSpec").field("spec.keyword"));

        builder.withQuery(boolQuery);
        return builder.build();
    }

    // 对搜索入参带有特殊符号进行处理
    public void handlerSearchMap(Map<String, String> searchMap) {
        if (null != searchMap) {
            Set<Map.Entry<String, String>> entries = searchMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                if (entry.getKey().startsWith("spec_")) {
                    searchMap.put(entry.getKey(), entry.getValue().replace("+", "%2B"));
                }
            }
        }
    }

}
