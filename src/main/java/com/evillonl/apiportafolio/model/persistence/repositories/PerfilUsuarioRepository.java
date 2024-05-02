package com.evillonl.apiportafolio.model.persistence.repositories;

import com.evillonl.apiportafolio.model.persistence.entities.PerfilUsurio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsurio, Long> {
}
