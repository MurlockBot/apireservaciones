package com.empresa.apireservaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private Integer status;

    private String mensaje;

    private LocalDateTime horario;

    ErrorResponse(String mensaje) {
        this.mensaje = mensaje;
    }
}
