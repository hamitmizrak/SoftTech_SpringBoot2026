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

    // 1- basic Auth
    private static final String BASIC_AUTH_SCHEME = "basicAuth";

    // 2- bearer Auth
    //private static final String SECURITY_SCHEME_NAME = "bearerAuth";


    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI()

                // Basic Auth için (Swagger kulalnmak için)
                .components(new Components().addSecuritySchemes(BASIC_AUTH_SCHEME, new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))

                .info(new Info()
                .title("M.Sc Hamit Mızrak")
                .version("V1.0.0")

                //.summary(" for spring boot on react js, auth: "+hashCode())
                .description("Spring Boot")
                .termsOfService("Software INC")
                .contact(new Contact()
                        .name("Hamit Mızrak")
                        .email("hamitmizrak@gmail.com")
                        .url("https://github.com/HamitMizrak")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/HamitMizrak")
                ))
                // Basic Auth Scheme
                .addSecurityItem(new SecurityRequirement().addList(BASIC_AUTH_SCHEME));


                // Swagger(open-api) eğer JWT varsa jwt ile open-api kullanabileceğim.
                /*.addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(
                        SECURITY_SCHEME_NAME,
                        new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT") // sadece bilgilendirici
                            ));*/
    } //end getOpenAPIMethod
} //end class

