package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductoRequest {

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}
