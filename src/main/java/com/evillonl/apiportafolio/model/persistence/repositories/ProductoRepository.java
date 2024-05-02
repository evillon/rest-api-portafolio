package com.evillonl.apiportafolio.model.persistence.repositories;

import com.evillonl.apiportafolio.model.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findAllByEstado(Integer estado);
}
