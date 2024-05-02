package com.evillonl.apiportafolio.model.persistence.repositories;

import com.evillonl.apiportafolio.model.persistence.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
