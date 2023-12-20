package com.empresa.apireservaciones.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API-Reservaciones",
                description = "API para Reservaciones de Clientes en Hoteles",
                version = "1.0"
        )
)
public class SwaggerConfig {
}
