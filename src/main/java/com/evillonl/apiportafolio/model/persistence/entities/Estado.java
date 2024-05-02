package com.evillonl.apiportafolio.model.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
@Builder
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    private LocalDateTime fechaRegistro;

    private String registradoPor;

    private LocalDateTime fechaModificacion;

    private String modificadoPor;
}
