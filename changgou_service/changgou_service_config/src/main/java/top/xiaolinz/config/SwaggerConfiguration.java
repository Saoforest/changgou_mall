package top.xiaolinz.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
// @EnableSwaggerBootstrapUI
// @EnableOpenApi
@EnableSwagger2
public class SwaggerConfiguration {

	private final OpenApiExtensionResolver openApiExtensionResolver;

	@Autowired
	public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
		this.openApiExtensionResolver = openApiExtensionResolver;
	}

	// @Bean
	// public Docket createRestApi() {
	// 	return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("top.xiaolinz.goods.controller")).paths(PathSelectors.any()).build();
	// }
	//
	// private ApiInfo apiInfo() {
	// 	return new ApiInfoBuilder().title("畅购商城商品文档").description("畅购商城").contact(new Contact("Yangkai.Shen", "https://www.xiaolinz.top", "a1051541160@qq.com")).version("1.0.0-SNAPSHOT").build();
	// }

	@Bean
	public Docket createRestApi() {
		final Contact contact = new Contact("XiaoLin", "https://www.xiaolinz.top", "a1051541160@qq.com");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						//.title("swagger-bootstrap-ui-demo RESTful APIs")
						.description("畅购商城配置服务")
						.termsOfServiceUrl("https://www.xiaolinz.top/")
						.contact(contact)
						.version("1.0")
						.build())
				//分组名称
				.groupName("1.0")
				.select()
				//这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("top.xiaolinz.business.controller"))
				.paths(PathSelectors.any())
				.build()
				.extensions(openApiExtensionResolver.buildSettingExtensions());
	}
}
