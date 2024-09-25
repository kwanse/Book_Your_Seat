package com.example.book_your_seat.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("book-your-seat API")
                        .description("book-your-seat의 API 문서입니다.")
                        .version("1.0.0"));
    }

    //UserController 설정
    @Bean
    public GroupedOpenApi bookYourSeatApi() {
        return GroupedOpenApi.builder()
                .group("user API")
                .pathsToMatch("/api/v1/users/**")
                .build();
    }

}