package com.example.tasklist.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tasklist API")
                        .version("1.0.0")
                        .description("A simple Spring Boot API for managing tasks.")
                        .contact(new Contact()
                                .name("Nondumiso Thwala")
                                .email("nondumiso@example.com")
                                .url("https://github.com/yourprofile")
                        )
                );
    }
}
