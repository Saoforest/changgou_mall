package top.xiaolinz.goods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author XiaoLin
 * @date 2022/3/7 00:35
 * @blog https://www.xiaolinz.top/
 *
 * swagger 配置
 **/
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("top.xiaolinz.goods.controller")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("畅购商城商品文档").description("畅购商城").contact(new Contact("Yangkai.Shen", "https://www.xiaolinz.top", "a1051541160@qq.com")).version("1.0.0-SNAPSHOT").build();
	}
}
