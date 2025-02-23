package com.testing.tic_tac_toe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tic Tac Toe")
                        .description("Tic Tac Toe Backend Service")
                        .version("1.0.0-dev")
                );
    }

}
