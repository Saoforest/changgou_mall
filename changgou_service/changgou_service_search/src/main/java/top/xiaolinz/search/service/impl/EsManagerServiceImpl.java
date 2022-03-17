package top.xiaolinz.search.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.feign.SkuFeign;
import top.xiaolinz.search.exception.Assert;
import top.xiaolinz.search.mapper.EsRepository;
import top.xiaolinz.search.service.EsManagerService;
import top.xiaolinz.search_api.entity.SkuInfo;

/**
 * @author XiaoLin
 * @date 2022/3/15 16:40
 * @blog https://www.xiaolinz.top/
 **/
@Service
@Slf4j
public class EsManagerServiceImpl implements EsManagerService {

    @Autowired
    private EsRepository esRepository;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private ElasticsearchRestTemplate esTemplate;

    @Override
    public void createIndex() {
        final boolean exists = this.esTemplate.indexOps(SkuInfo.class).exists();
        if (!exists) {
            this.esTemplate.indexOps(SkuInfo.class).create();

            final Document mapping = this.esTemplate.indexOps(SkuInfo.class).createMapping();

            this.esTemplate.indexOps(SkuInfo.class).putMapping(mapping);
        }
    }

    @Override
    public void importAll() {
        final R r = this.skuFeign.findSkuListBySpuId("all");
        if (r.getCode() != StatusCode.ERROR) {
            List<Sku> data = r.getData("data", new TypeReference<List<Sku>>() {});
            Assert.notEmpty(data);
            final List<SkuInfo> skuInfos = data.stream().map(sku -> {
                final SkuInfo info = new SkuInfo();
                BeanUtils.copyProperties(sku, info);
                final Map<String, Object> map =
                    JSONUtil.toBean(sku.getSpec(), new TypeReference<Map<String, Object>>() {}, true);

                info.setSpecMap(map);

                // log.info("返回的封装对象{}", info);

                return info;
            }).collect(Collectors.toList());

            final List<List<SkuInfo>> split = ListUtil.split(skuInfos, 2000);

            for (List<SkuInfo> infos : split) {
                ThreadUtil.execAsync(() -> {
                    this.esTemplate.save(infos);
                });
            }
        }
    }

    @Override
    public void importBySpuId(String spuId) {
        final R r = this.skuFeign.findSkuListBySpuId(spuId);
        if (r.getCode() != StatusCode.ERROR) {
            final List<Sku> skus = r.getData("data", new TypeReference<List<Sku>>() {});
            Assert.notEmpty(skus);
            final List<SkuInfo> infos = skus.stream().map(sku -> {
                final SkuInfo info = new SkuInfo();

                BeanUtils.copyProperties(sku, info);

                final Map<String, Object> map =
                    JSONUtil.toBean(sku.getSpec(), new TypeReference<Map<String, Object>>() {}, true);

                info.setSpecMap(map);

                return info;
            }).collect(Collectors.toList());

            final List<List<SkuInfo>> split = ListUtil.split(infos, 2000);

            for (List<SkuInfo> info : split) {
                ThreadUtil.execAsync(() -> {
                    this.esTemplate.save(info);
                });

            }
        }
    }

    @Override
    public void deleteBySpuId(String spuId) {
        final NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.termQuery("spuId", spuId));
        final NativeSearchQuery build = builder.build();

        final SearchHits<SkuInfo> hits = this.esTemplate.search(build, SkuInfo.class);
        final List<SearchHit<SkuInfo>> searchHits = hits.getSearchHits();

        final List<SkuInfo> skuInfos = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());

        // System.out.println(skuInfos);
        Assert.notEmpty(skuInfos);

        this.esRepository.deleteAll(skuInfos);
    }
}
