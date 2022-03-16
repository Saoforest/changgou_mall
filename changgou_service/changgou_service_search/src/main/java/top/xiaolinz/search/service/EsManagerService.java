package top.xiaolinz.search.service;

/**
 * @author XiaoLin
 * @date 2022/3/15 16:39
 * @blog https://www.xiaolinz.top/
 **/
public interface EsManagerService {

    /**
     * 创建索引
     */
    void createIndex();

    /**
     * 导入所有正常的sku到es
     */
    void importAll();

    /**
     * 根据spuId导入所有sku
     * 
     * @param spuId
     *            spu编号
     */
    void importBySpuId(String spuId);

    /**
     * 根据spu删除sku
     * 
     * @param spuId
     *            spuId
     */
    void deleteBySpuId(String spuId);
}
