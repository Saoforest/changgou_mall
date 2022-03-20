package top.xiaolinz.business.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import top.xiaolinz.business_api.entity.Ad;

/**
 * @author XiaoLin
 * @date 2022/3/17 21:38
 * @blog https://www.xiaolinz.top/
 **/
public class Main {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;
        final Ad ad = new Ad();
        test(a, b);

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        final List<Integer> collect = list.parallelStream().parallel().map(item -> {
            return item + 1;
        }).collect(Collectors.toList());

        System.out.println(collect);

        test2(ad);
    }

    public static void test(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    public static void test2(Ad ad) {
        ad.setName("你是傻逼");
    }
}
