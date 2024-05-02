package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String clave;
}
