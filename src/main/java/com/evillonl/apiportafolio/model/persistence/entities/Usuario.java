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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;

    private String correo;

    private String clave;

    private String identificacion;

    private String nombres;

    private String apellidos;

    private LocalDate fechaExpiracion;

    private Integer estado;

    private LocalDateTime fechaRegistro;

    private String registradoPor;

    private LocalDateTime fechaModificacion;

    private String modificadoPor;


}
