package com.empresa.apireservaciones.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestUpdate {

    @Size(min = 2, max = 20)
    @NotEmpty(message = "El campo Nombres no puede estar vacío.")
    private String nombres;

    @NotEmpty(message = "El campo Apellidos no puede estar vacío.")
    @Size(min = 2, max = 20)
    private String apellidos;

    @NotEmpty(message = "La fecha de Nacimiento tiene que contener carácteres válidos.")
    private LocalDate fechaNacimiento;
}
