package com.davidlima.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Description of SwaggerConfig.
 *
 * @author David Lima
 */

@OpenAPIDefinition(
    info = @Info(
        title = "Ecommerce Postgrado Api",
        description = "Back Pack ecommerce",
        version = "1.0",
        contact = @Contact(
            name = "Postgrado",
            email = "no.reply.gerson2050@hotmail.com"
        )
    )
)

@SecurityScheme(
    name = "bearerAuth",
    description = "Authentication JWT",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)

@Configuration
public class SwaggerConfig {

}
