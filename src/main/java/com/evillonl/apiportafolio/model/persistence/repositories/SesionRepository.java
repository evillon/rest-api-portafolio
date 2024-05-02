package com.evillonl.apiportafolio.model.persistence.repositories;

import com.evillonl.apiportafolio.model.persistence.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository<SessionEntity, Long> {

    List<SessionEntity> findAllByEstado(Integer estado);
}
