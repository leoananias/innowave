package com.innowave.challenge.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .apis( RequestHandlerSelectors.basePackage("com.innowave.challenge.controller"))
                //.paths(PathSelectors.any())
                .build()
                .apiInfo(ApiInformation());
    }

    private ApiInfo ApiInformation() {
        return new ApiInfoBuilder()
                .title("Challenge Innowave")
                .description("Springboot, H2 and REST Challenge")
                .version("1.0.0")
                .build();
    }
}
