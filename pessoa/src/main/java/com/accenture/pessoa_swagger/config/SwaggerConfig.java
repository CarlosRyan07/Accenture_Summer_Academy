package com.accenture.pessoa_swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        String securitySchemeName = "Authorization";
        
        return new OpenAPI()
                .info(new Info()
                        .title("Accenture - API")
                        .description("API para gerenciar pessoas - Accenture")
                        .version("1.0")
                        .termsOfService("https://accenture.com/terms")
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Licença - Accenture Academy")
                                .url("https://accenture.com/")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
