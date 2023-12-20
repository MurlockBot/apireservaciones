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
public class ClienteResponse {

    private Long numDocumento;

    private String nombres;

    private String apellidos;

    private LocalDateTime fechaCreacion;
}
