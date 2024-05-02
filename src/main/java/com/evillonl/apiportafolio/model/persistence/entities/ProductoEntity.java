package com.evillonl.apiportafolio.model.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Integer estado;

    private LocalDateTime fechaRegistro;

    private String registradoPor;

    private LocalDateTime fechaModificacion;

    private String modificadoPor;




}
