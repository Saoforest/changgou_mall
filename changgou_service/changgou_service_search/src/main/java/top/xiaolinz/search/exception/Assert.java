package top.xiaolinz.search.exception;

import java.util.List;

import cn.hutool.core.collection.CollUtil;
import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.StatusCode;

/**
 * @author XiaoLin
 * @date 2022/3/15 16:56
 * @blog https://www.xiaolinz.top/
 **/
public class Assert {

    public static void notEmpty(List list) {
        if (CollUtil.isEmpty(list)) {
            throw new BusinessException(StatusCode.ERROR, "查询的sku不存在");
        }
    }

    public static void isEmpty() {}
}
