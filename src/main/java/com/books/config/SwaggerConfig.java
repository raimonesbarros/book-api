package com.books.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI bookOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Book API")
                        .description("Spring books sample application")
                        .version("v0.0.1"));
    }
}