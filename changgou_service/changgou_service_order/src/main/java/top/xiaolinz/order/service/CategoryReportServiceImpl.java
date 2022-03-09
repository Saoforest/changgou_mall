package top.xiaolinz.order.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.order.mapper.CategoryReportMapper;
import top.xiaolinz.order_api.entity.CategoryReport;
import top.xiaolinz.order_api.service.CategoryReportService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class CategoryReportServiceImpl extends ServiceImpl<CategoryReportMapper, CategoryReport> implements CategoryReportService{

}
