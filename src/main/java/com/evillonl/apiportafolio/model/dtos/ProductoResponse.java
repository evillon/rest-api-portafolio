package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProductoResponse {

    private Long id;

    private String nombre;

    private String descripcion;

    private String imagen;

    private String enlace;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Integer estado;

    private LocalDateTime fechaRegistro;

}
