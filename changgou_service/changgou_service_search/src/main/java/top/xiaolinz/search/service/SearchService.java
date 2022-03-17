package top.xiaolinz.search.service;

import java.util.Map;

/**
 * @author XiaoLin
 * @date 2022/3/16 10:24
 * @blog https://www.xiaolinz.top/
 **/
public interface SearchService {

    /**
     * 多条件检索
     * 
     * @param map
     *            条件集合
     * @return 对象
     */
    Map<String, Object> search(Map<String, String> map);
}
