package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SesionesResponse {

    private Long idAplicacion;

    private Long idUsuario;

    private String token;

    private Integer estado;

    private LocalDateTime fechaRegistro;

}
