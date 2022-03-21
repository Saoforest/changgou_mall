package top.xiaolinz.search.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import top.xiaolinz.common.utils.Page;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.common.utils.StatusCode;
import top.xiaolinz.search.service.SearchService;
import top.xiaolinz.search_api.entity.SkuInfo;

/**
 * @author XiaoLin
 * @date 2022/3/16 10:46
 * @blog https://www.xiaolinz.top/
 **/
@Controller
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/list")
    public String find(@RequestParam Map<String, String> param, Model model) {
        HashMap<String, String> map = (HashMap<String, String>)param;
        if (map == null) {
            map = new HashMap<>();
        }
        final Map<String, Object> search = this.searchService.search(map);
        log.info("请求参数为:{}", map);
        model.addAttribute("paramMap", map);
        model.addAttribute("result", search);

        // 分页
        final Page<SkuInfo> page = new Page<>();
        page.initPage((Long)search.get("total"), Integer.parseInt(map.get("page")),
            Math.toIntExact((Long)search.get("totalPages")));

        // 拼接url,保证线程安全
        final StringBuffer url = new StringBuffer("/search/list");
        if (map.size() > 0) {
            url.append("?");
            for (String s : map.keySet()) {
                if (!"sortRule".equals(s) || !"sortField".equals(s) || !"page".equals(s)) {
                    url.append(s).append("=").append(map.get(s)).append("&");
                }
            }
            final String s = url.substring(0, url.length() - 1);
            model.addAttribute("url", s);
        } else {
            model.addAttribute("url", url.toString());
        }

        return "search";
    }

    @GetMapping("/info")
    @ResponseBody
    public R search(@RequestParam Map<String, String> param) {
        final Map<String, Object> search = this.searchService.search(param);

        return R.ok(StatusCode.OK, "查询成功").put("data", search);
    }
}
