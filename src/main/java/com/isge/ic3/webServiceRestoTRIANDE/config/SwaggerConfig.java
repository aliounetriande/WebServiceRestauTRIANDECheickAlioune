package com.isge.ic3.webServiceRestoTRIANDE.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API de Gestion de Restaurant")
                        .version("1.0")
                        .description("Documentation des API restau Alioune.")
                        .contact(new Contact()
                                .name("Support Technique")
                                .email("support@resto.com")
                                .url("https://resto.com")
                        )
                );
    }
}
