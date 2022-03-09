package top.xiaolinz.order_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_category_report")
public class CategoryReport implements Serializable {
    /**
     * 1级分类
     */
    @TableId(value = "category_id1", type = IdType.AUTO)
    private Integer categoryId1;

    /**
     * 2级分类
     */
    @TableId(value = "category_id2", type = IdType.AUTO)
    private Integer categoryId2;

    /**
     * 3级分类
     */
    @TableId(value = "category_id3", type = IdType.AUTO)
    private Integer categoryId3;

    /**
     * 统计日期
     */
    @TableId(value = "count_date", type = IdType.AUTO)
    private Date countDate;

    /**
     * 销售数量
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 销售额
     */
    @TableField(value = "money")
    private Integer money;

    private static final long serialVersionUID = 1L;

    public static final String COL_CATEGORY_ID1 = "category_id1";

    public static final String COL_CATEGORY_ID2 = "category_id2";

    public static final String COL_CATEGORY_ID3 = "category_id3";

    public static final String COL_COUNT_DATE = "count_date";

    public static final String COL_NUM = "num";

    public static final String COL_MONEY = "money";
}