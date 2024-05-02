package com.evillonl.apiportafolio.model.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDashboard {
    Integer cantidad;
    LocalDate fecha;
}
