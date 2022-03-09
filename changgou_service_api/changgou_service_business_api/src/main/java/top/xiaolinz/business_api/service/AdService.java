package top.xiaolinz.business_api.service;

import top.xiaolinz.business_api.entity.Ad;
import top.xiaolinz.business_api.entity.Ad;
import com.baomidou.mybatisplus.extension.service.IService;
import top.xiaolinz.business_api.vo.PageAdRequestVo;
import top.xiaolinz.common_db.utils.PageResult;

import java.util.List;

/**
* 
* @author XiaoLin
* @date 2022/3/8 23:41
* @blog https://www.xiaolinz.top/
* 
**/
public interface AdService extends IService<Ad>{

    /**
     * 查询所有ad
     *
     * @return ad集合
     */
    List<Ad> findAll();


    /**
     * 根据id查询对应ad
     * @param id adId
     * @return ad对象
     */
    Ad findAdById(Integer id);


    /**
     * 添加数据
     * @param Ad 数据信息
     */
    void addAd(Ad Ad);

    /**
     * 修改数据
     * @param Ad 数据对象
     */
    void updateAd(Ad Ad);


    /**
     * 删除数据
     * @param id 数据id
     */
    void deleteAd(Integer id);

    /**
     * 条件查询数据
     * @param Ad 数据条件信息
     * @return 查询到的数据集
     */
    List<Ad> findAdByConditions(Ad Ad);


    /**
     * 分页查询
     *
     * @param vo 条件封装
     * @return 分页数据
     */
    PageResult<Ad> findByPage(PageAdRequestVo vo);

    /**
     * 分页条件查询
     * @param vo 条件封装
     * @return 结果集
     */
    PageResult<Ad> findByPageAndCondition(PageAdRequestVo vo);
}
