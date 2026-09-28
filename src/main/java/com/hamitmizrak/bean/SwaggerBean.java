package com.hamitmizrak.bean;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerBean {

    // bearer Auth
    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("Master Computer Engineer Hamit Mızrak")
                .version("V1.0.0")

                //.summary(" for spring boot on react js, auth: "+hashCode())
                .description("Spring Boot & React Js & Devops")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Hamit Mızrak")
                        .email("hamitmizrak@gmail.com")
                        .url("https://github.com/HamitMizrak")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/HamitMizrak")
                ))
                // Swagger(open-api) eğer JWT varsa jwt ile open-api kullanabileceğim.
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(
                        SECURITY_SCHEME_NAME,
                        new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT") // sadece bilgilendirici
                            ));
    } //end getOpenAPIMethod
} //end class

