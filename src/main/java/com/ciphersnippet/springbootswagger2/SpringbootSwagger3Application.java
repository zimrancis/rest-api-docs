package com.ciphersnippet.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class SpringbootSwagger3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger3Application.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.ciphersnippet"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Address book API",
                "sample API for ciphersnppet App",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Zobair imran", "http://ciphersnippet.com", "a@b.com"),
                "API License",
                "htp://ciphersnippet.com",
                Collections.emptyList());
    }


}
