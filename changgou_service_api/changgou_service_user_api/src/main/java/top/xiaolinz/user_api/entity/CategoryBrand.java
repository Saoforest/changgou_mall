package top.xiaolinz.user_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:53
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_category_brand")
public class CategoryBrand implements Serializable {
    /**
     * 分类ID
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 品牌ID
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Integer brandId;

    private static final long serialVersionUID = 1L;

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_BRAND_ID = "brand_id";
}