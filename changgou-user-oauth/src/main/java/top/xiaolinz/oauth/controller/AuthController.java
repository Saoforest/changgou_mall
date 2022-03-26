package top.xiaolinz.oauth.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import top.xiaolinz.common.exception.BusinessException;
import top.xiaolinz.common.utils.R;
import top.xiaolinz.oauth.service.AuthService;
import top.xiaolinz.oauth.util.AuthToken;
import top.xiaolinz.oauth.util.CookieUtil;

/**
 * @author XiaoLin
 * @date 2022/3/22 17:30
 * @blog https://www.xiaolinz.top/
 **/
@Controller
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        if (StringUtils.isBlank(username)) {
            throw new BusinessException("请输入用户名");
        }

        if (StringUtils.isBlank(password)) {
            throw new BusinessException("请输入密码");
        }

        final AuthToken token = this.authService.login(username, password, this.clientId, this.clientSecret);

        // 将jti的值存入cookie
        this.saveCookie(token.getJti(), response);

        return R.ok().put("data", token);
    }

    public void saveCookie(String jti, HttpServletResponse response) {
        CookieUtil.addCookie(response, this.cookieDomain, "/", "uid", jti, this.cookieMaxAge, false);
    }

    @GetMapping("/login.html")
    public String login(@RequestParam(value = "from",required = false,defaultValue = "") String url, Model model){
        model.addAttribute("from",url);
        return "login";
    }
}
