package top.xiaolinz.order.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.order_api.entity.TaskHis;
import top.xiaolinz.order.mapper.TaskHisMapper;
import top.xiaolinz.order_api.service.TaskHisService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class TaskHisServiceImpl extends ServiceImpl<TaskHisMapper, TaskHis> implements TaskHisService{

}
