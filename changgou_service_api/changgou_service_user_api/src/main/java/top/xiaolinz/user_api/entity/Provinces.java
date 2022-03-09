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
    * 省份信息表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_provinces")
public class Provinces implements Serializable {
    /**
     * 省份ID
     */
    @TableId(value = "provinceid", type = IdType.AUTO)
    private String provinceid;

    /**
     * 省份名称
     */
    @TableField(value = "province")
    private String province;

    private static final long serialVersionUID = 1L;

    public static final String COL_PROVINCEID = "provinceid";

    public static final String COL_PROVINCE = "province";
}