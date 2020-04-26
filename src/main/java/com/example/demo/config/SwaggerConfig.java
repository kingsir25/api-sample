package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.api"))
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfoBuilder()
						.title("PDWF Payment Status Search API")
						.description("PDWF Payment Status Search API (支払状況ステータス検索) detail info: SpringBoot2 + Swagger2.9.2 ......")
						.termsOfServiceUrl("https://wjrwww0y01.ads-jp.intraxa:82/PDWorkflow/API")
						.version("1.0.0")
						.contact(new Contact("XXX.SSS", "XXX.XXX.com", "XXX@Xmail.com"))
						.license("XXXX License")
						.licenseUrl("https://www.licenseUrl.com")
						.build());
	}
}