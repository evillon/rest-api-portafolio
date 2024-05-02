package com.evillonl.apiportafolio.config;


import com.evillonl.apiportafolio.model.persistence.entities.Estado;
import com.evillonl.apiportafolio.model.persistence.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.time.LocalDateTime;

@Configuration
public class InitialConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Inserta los estados por defecto
        if (estadoRepository.count() == 0) {
            estadoRepository.save(Estado.builder().descripcion("activo").fechaRegistro(LocalDateTime.now()).registradoPor("CONFIG").build());
            estadoRepository.save(Estado.builder().descripcion("inactivo").fechaRegistro(LocalDateTime.now()).registradoPor("CONFIG").build());
            estadoRepository.save(Estado.builder().descripcion("bloqueado").fechaRegistro(LocalDateTime.now()).registradoPor("CONFIG").build());
            estadoRepository.save(Estado.builder().descripcion("pendiente").fechaRegistro(LocalDateTime.now()).registradoPor("CONFIG").build());
            // etc.
        }
    }
}