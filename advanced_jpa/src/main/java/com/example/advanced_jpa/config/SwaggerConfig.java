// swagger-ui 가 안보이는데 왜 안될까?

package com.example.advanced_jpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "API Document",
                description = "spring boot study with advanced jpa API 명세서",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi OpenApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("API Document v1")
                .pathsToMatch("/**")
                .build();
    }
}

