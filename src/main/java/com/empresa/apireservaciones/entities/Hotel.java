package com.empresa.apireservaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "hoteles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_hotel")
    private String nombreHotel;

    private String direccion;

    @Column(name = "precio_noche")
    private BigDecimal precioNoche;

    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Reservacion> reservaciones;
}
