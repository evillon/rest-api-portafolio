package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

@Data
public class RegistroRequest {

    String nombres;
    String apellidos;
    String identificacion;
    String correo;
    String usuario;
    String clave;

}
