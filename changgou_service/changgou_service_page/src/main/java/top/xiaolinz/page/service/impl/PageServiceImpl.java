package top.xiaolinz.page.service.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.goods_api.entity.Category;
import top.xiaolinz.goods_api.entity.Sku;
import top.xiaolinz.goods_api.entity.Spu;
import top.xiaolinz.goods_api.feign.CategoryFeign;
import top.xiaolinz.goods_api.feign.SkuFeign;
import top.xiaolinz.goods_api.feign.SpuFeign;
import top.xiaolinz.page.service.PageService;

/**
 * @author XiaoLin
 * @date 2022/3/20 23:26
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private SpuFeign spuFeign;

    @Autowired
    private CategoryFeign categoryFeign;

    @Autowired
    private Environment environment;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void generateHtml(String spuId) {
        // 创建用于存储商品数据的对象
        final Context context = new Context();

        // 根据商品id,获取相关数据
        Map<String, Object> data = this.getItemData(spuId);

        // 将数据保存至上下文内
        context.setVariables(data);

        // 指定生成的页面位置
        final String pagepath = this.environment.getProperty("pagepath");
        final File file = new File(pagepath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 创建文件输出流对象
        final File file1 = new File(file + "/" + spuId + ".html");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file1);
            this.templateEngine.process("item", context, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Map<String, Object> getItemData(String spuId) {
        final HashMap<String, Object> resMap = new HashMap<>();

        // 获取spu信息
        final R resSpu = this.spuFeign.findSpuById(spuId);
        final Spu spu = resSpu.getData("data", Spu.class);
        resMap.put("spu", spu);

        // 获取图片的信息
        if (spu != null) {
            final String images = spu.getImages();
            if (StringUtils.isNotBlank(images)) {
                resMap.put("imageList", spu.getImages().split(","));
            }
        }

        // 获取商品的分类信息
        final R resCategory1 = this.categoryFeign.findById(spu.getCategory1Id());
        final Category category1 = resCategory1.getData("data", Category.class);
        resMap.put("category1", category1);

        final R resCategory2 = this.categoryFeign.findById(spu.getCategory2Id());
        final Category category2 = resCategory2.getData("data", Category.class);
        resMap.put("category2", category2);

        final R resCategory3 = this.categoryFeign.findById(spu.getCategory3Id());
        final Category category3 = resCategory3.getData("data", Category.class);
        resMap.put("category3", category3);

        // 获取sku数据
        final R resSku = this.skuFeign.findSkuListBySpuId(spuId);
        final List<Sku> skus = resSku.getData("data", new TypeReference<List<Sku>>() {});
        resMap.put("skuList", skus);

        // 获取规格数据
        final String specItems = spu.getSpecItems();
        final HashMap<String, Object> specs =
            JSONUtil.toBean(specItems, new TypeReference<HashMap<String, Object>>() {}, true);
        resMap.put("specificationList", specs);

        return resMap;
    }

}
