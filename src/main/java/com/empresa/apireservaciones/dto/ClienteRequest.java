package com.empresa.apireservaciones.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequest implements Serializable {

    @NotEmpty(message = "El campo Número de Documento no puede estar vacío.")
    @Size(min = 2, max = 9)
    private Long numDocumento;

    @NotEmpty(message = "El campo ID Tributaria no puede estar vacío.")
    @Size(min = 8, max = 15)
    private Long idTributaria;

    @NotEmpty(message = "El campo Nombres no puede estar vacío.")
    @Size(min = 2, max = 20)
    private String nombres;

    @NotEmpty(message = "El campo Apellidos no puede estar vacío.")
    @Size(min = 2, max = 20)
    private String apellidos;

    @NotEmpty(message = "La fecha de Nacimiento tiene que contener carácteres válidos.")
    private LocalDate fechaNacimiento;
}
