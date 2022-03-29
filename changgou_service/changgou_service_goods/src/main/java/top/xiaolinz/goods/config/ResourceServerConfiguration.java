package top.xiaolinz.goods.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author XiaoLin
 * @date 2022/3/22 15:25
 * @blog https://www.xiaolinz.top/
 **/
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    // 公钥
    private static final String PUBLIC_KEY = "public.key";

    /***
     * Http安全配置，对每个到达系统的http请求链接进行校验
     * 
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 所有请求必须认证通过
        http.authorizeRequests()
            // 下边的路径放行
            .antMatchers("/user/add", "/user/load/**"). // 配置地址放行
            permitAll().anyRequest().authenticated(); // 其他地址需要认证授权
    }

    /**
     * 定义JwtTokenStore
     */
    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    /**
     * 定义JJwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(this.getPublicKey());

        return converter;
    }

    /**
     * 读取公钥文件
     */
    private String getPublicKey() {
        final ClassPathResource resource = new ClassPathResource(PUBLIC_KEY);
        try {
            final InputStreamReader streamReader = new InputStreamReader(resource.getInputStream());
            final BufferedReader reader = new BufferedReader(streamReader);

            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
