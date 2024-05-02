package com.evillonl.apiportafolio.model.builders;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@Builder
public class EstadoBuilder {

    private String descripcion;

    private LocalDateTime fechaRegistro;

    private String registradoPor;


}
