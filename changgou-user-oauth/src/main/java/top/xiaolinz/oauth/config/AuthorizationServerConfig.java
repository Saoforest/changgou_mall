package top.xiaolinz.oauth.config;

import java.security.KeyPair;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    // SpringSecurity 用户自定义授权认证类
    @Autowired
    UserDetailsService userDetailsService;
    // 授权认证管理器
    @Autowired
    AuthenticationManager authenticationManager;
    // 令牌持久化存储接口
    @Autowired
    TokenStore tokenStore;
    // 数据源，用于从数据库获取数据进行认证操作，测试可以从内存中获取
    @Autowired
    private DataSource dataSource;
    // jwt令牌转换器
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private CustomUserAuthenticationConverter customUserAuthenticationConverter;
    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    /***
     * 客户端信息配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(this.dataSource).clients(this.clientDetails());
    }

    /***
     * 授权服务器端点配置
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(this.jwtAccessTokenConverter).authenticationManager(this.authenticationManager)// 认证管理器
            .tokenStore(this.tokenStore) // 令牌存储
            .userDetailsService(this.userDetailsService); // 用户信息service
    }

    /***
     * 授权服务器的安全配置
     *
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients().passwordEncoder(new BCryptPasswordEncoder())
            .tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    // 读取密钥的配置
    @Bean("keyProp")
    public KeyProperties keyProperties() {
        return new KeyProperties();
    }

    // 客户端配置
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(this.dataSource);
    }

    @Bean
    @Autowired
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    /****
     * JWT令牌转换器
     * 
     * @param customUserAuthenticationConverter
     * @return
     */
    @Bean
    public JwtAccessTokenConverter
        jwtAccessTokenConverter(CustomUserAuthenticationConverter customUserAuthenticationConverter) {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(this.keyProperties.getKeyStore().getLocation(), // 证书路径 changgou.jks
                this.keyProperties.getKeyStore().getSecret().toCharArray()) // 证书秘钥 changgouapp
                .getKeyPair(this.keyProperties.getKeyStore().getAlias(), // 证书别名 changgou
                        this.keyProperties.getKeyStore().getPassword().toCharArray()); // 证书密码 changgou
        converter.setKeyPair(keyPair);
        // 配置自定义的CustomUserAuthenticationConverter
        DefaultAccessTokenConverter accessTokenConverter =
            (DefaultAccessTokenConverter)converter.getAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(customUserAuthenticationConverter);
        return converter;
    }
}
