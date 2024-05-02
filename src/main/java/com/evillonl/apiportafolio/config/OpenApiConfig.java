package com.evillonl.apiportafolio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST API")
                        .description("This is a Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Hiper S.A.")
                                .url("https://www.empresa.com.ec/")
                                .email("contacto@empresa.com.ec")) // Agregar si es necesario
                )
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", new SecurityScheme()
                                //.type(SecuritySchemeType.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                //.in(SecuritySchemeIn.HEADER)
                                .name("Authorization"))
                )
                ;
    }
}
