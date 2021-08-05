package sube.apps.messageApi.conf;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/v*/**")).build().apiInfo(getMetadata());
	}

	private ApiInfo getMetadata() {
		ApiInfo apiInfo = new ApiInfo("NSSA messageApi", "Api de envío de mensajes", "1", "",
				new Contact("Nacion Servicios", "https://www.nacionservicios.com.ar", "info@nacionservicios.com.ar"),
				"NSSA Standard License", "https://www.nacionservicios.com.ar/license", new ArrayList<>());
		return apiInfo;
	}

	@Bean
	public UiConfiguration tryItOutConfig() {
		final String[] methodsWithTryItOutButton = { "get" };
		return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
	}
}