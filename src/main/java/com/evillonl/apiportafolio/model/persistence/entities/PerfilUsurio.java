package com.evillonl.apiportafolio.model.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class PerfilUsurio {

    @Id
    private Long id;

    private Integer estado;

    private LocalDateTime fechaRegistro;

    private String registradoPor;

    private LocalDateTime fechaModificacion;

    private String modificadoPor;
}
