package top.xiaolinz.web.filter;

/**
 * @author XiaoLin
 * @date 2022/3/23 21:21
 * @blog https://www.xiaolinz.top/
 **/
public class UrlFilter {
    public static String filterPath =
        "/api/wseckillorder,/api/seckill,/api/wxpay,/api/wxpay/**,/api/worder/**,/api/user/**,/api/address/**,/api/wcart/**,/api/cart/**,/api/categoryReport/**,/api/orderConfig/**,/api/order/**,/api/orderItem/**,/api/orderLog/**,/api/preferential/**,/api/returnCause/**,/api/returnOrder/**,/api/returnOrderItem/**";

    public static boolean hasAuthorize(String url) {

        String[] split = filterPath.replace("**", "").split(",");

        for (String value : split) {

            if (url.startsWith(value)) {
                return true;
            }
        }

        return false;
    }
}
