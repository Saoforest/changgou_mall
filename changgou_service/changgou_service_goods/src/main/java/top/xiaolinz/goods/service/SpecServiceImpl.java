package top.xiaolinz.goods.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.goods_api.entity.Spec;
import top.xiaolinz.goods.mapper.SpecMapper;
import top.xiaolinz.goods_api.service.SpecService;

/**
 * @author XiaoLin
 * @date 2022/3/6 23:48
 * @blog https://www.xiaolinz.top/
 **/
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements SpecService {

}

