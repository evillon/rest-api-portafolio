package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.ProductoRequest;
import org.springframework.http.ResponseEntity;

public interface ProductoService {
    ResponseEntity<Object> registrar(ProductoRequest request);

    ResponseEntity<Object> actualizar(Long id, ProductoRequest request);

    ResponseEntity<Object> consultar();

    ResponseEntity<Object> consultarPorId(Long id);

    ResponseEntity<Object> eliminarPorId(Long id);
}
