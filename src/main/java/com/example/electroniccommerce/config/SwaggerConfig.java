package com.example.electroniccommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${application-description}") String appDescription,
            @Value("${application-version}") String appVersion,
            @Value("${application-name}") String appName,
            @Value("${application-contact-name}") String appContactName,
            @Value("${application-contact-mail}") String appContactMail,
            @Value("${application-business-name}") String appBusinessName,
            @Value("${application-business-web}") String appBusinessWeb) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title(appName)
                                .version(appVersion)
                                .description(appDescription)
                                .license(new License().name(appBusinessName).url(appBusinessWeb))
                                .contact(new Contact().name(appContactName).email(appContactMail)));
    }
}
