package com.evillonl.apiportafolio.model.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idAplicacion;

    private Long idUsuario;

    private String token;

    private Integer estado;

    private LocalDateTime fechaRegistro;

    private String registradoPor;

    private LocalDateTime fechaModificacion;

    private String modificadoPor;
}
