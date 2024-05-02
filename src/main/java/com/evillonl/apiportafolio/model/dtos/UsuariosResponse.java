package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsuariosResponse {

    private String usuario;

    private String correo;

    private String clave;

    private String identificacion;

    private String nombres;

    private String apellidos;

    private LocalDate fechaExpiracion;

    private Integer estado;

    private LocalDateTime fechaRegistro;

}
