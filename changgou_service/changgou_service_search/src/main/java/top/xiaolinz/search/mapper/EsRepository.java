package top.xiaolinz.search.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import top.xiaolinz.search_api.entity.SkuInfo;

/**
 * @author XiaoLin
 * @date 2022/3/15 16:38
 * @blog https://www.xiaolinz.top/
 **/
public interface EsRepository extends ElasticsearchRepository<SkuInfo, Long> {}
