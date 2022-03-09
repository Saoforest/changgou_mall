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
    * 行政区域县区信息表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_areas")
public class Areas implements Serializable {
    /**
     * 区域ID
     */
    @TableId(value = "areaid", type = IdType.AUTO)
    private String areaid;

    /**
     * 区域名称
     */
    @TableField(value = "area")
    private String area;

    /**
     * 城市ID
     */
    @TableField(value = "cityid")
    private String cityid;

    private static final long serialVersionUID = 1L;

    public static final String COL_AREAID = "areaid";

    public static final String COL_AREA = "area";

    public static final String COL_CITYID = "cityid";
}