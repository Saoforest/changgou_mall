package top.xiaolinz.order.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.xiaolinz.order.mapper.TaskMapper;
import top.xiaolinz.order_api.entity.Task;
import top.xiaolinz.order_api.service.TaskService;
/**
* 
* @author XiaoLin
* @date 2022/3/8 23:48
* @blog https://www.xiaolinz.top/
* 
**/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService{

}
