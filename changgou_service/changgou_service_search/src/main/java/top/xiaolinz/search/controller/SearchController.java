package top.xiaolinz.search.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.search.service.SearchService;

/**
 * @author XiaoLin
 * @date 2022/3/16 10:46
 * @blog https://www.xiaolinz.top/
 **/
@RestController()
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/info")
    public R search(@RequestParam Map<String, String> param) {
        final Map<String, Object> search = this.searchService.search(param);

        return R.ok(StatusCode.OK, "查询成功").put("data", search);
    }
}
