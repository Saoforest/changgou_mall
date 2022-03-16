package top.xiaolinz.search_api.entity;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * @author XiaoLin
 * @date 2022/3/15 15:06
 * @blog https://www.xiaolinz.top/
 **/
@Document(indexName = "skuinfo")
@Data
public class SkuInfo {

    @Id
    @Field(index = true, type = FieldType.Keyword)
    private String id;

    @Field(index = true, type = FieldType.Text, analyzer = "ik_smart", store = true)
    private String name;

    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer price;

    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer num;

    @Field(index = false, store = true, type = FieldType.Keyword)
    private String image;

    @Field(index = false, store = true, type = FieldType.Keyword)
    private String status;

    private Date createTime;

    private Date updateTime;

    @Field(index = true, store = true, type = FieldType.Keyword)
    private String spuId;

    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer categoryId;

    @Field(index = true, store = true, type = FieldType.Keyword)
    private String categoryName;

    @Field(index = true, store = true, type = FieldType.Keyword)
    private String brandName;

    private String spec;

    @Field(store = true, type = FieldType.Nested)
    private Map<String, Object> specMap;

    @Field(index = true, store = true, type = FieldType.Keyword)
    private String isDefault;
}
