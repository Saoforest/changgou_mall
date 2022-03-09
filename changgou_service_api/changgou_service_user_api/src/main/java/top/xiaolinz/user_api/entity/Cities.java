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
/**
    * 行政区域地州市信息表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_cities")
public class Cities implements Serializable {
    /**
     * 城市ID
     */
    @TableId(value = "cityid", type = IdType.AUTO)
    private String cityid;

    /**
     * 城市名称
     */
    @TableField(value = "city")
    private String city;

    /**
     * 省份ID
     */
    @TableField(value = "provinceid")
    private String provinceid;

    private static final long serialVersionUID = 1L;

    public static final String COL_CITYID = "cityid";

    public static final String COL_CITY = "city";

    public static final String COL_PROVINCEID = "provinceid";
}