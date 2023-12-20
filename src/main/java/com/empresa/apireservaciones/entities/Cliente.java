package com.empresa.apireservaciones.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    @Column(name = "num_documento")
    private Long numDocumento;

    @Column(name = "id_tributaria")
    private Long idTributaria;

    private String nombres;

    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "cantidad_reservaciones")
    private Integer cantidadReservaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(
            mappedBy = "cliente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Reservacion> reservaciones;

    @PrePersist
    public void asignarFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }

}
