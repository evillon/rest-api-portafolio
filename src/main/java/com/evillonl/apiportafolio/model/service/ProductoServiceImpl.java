package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.ProductoRequest;
import com.evillonl.apiportafolio.model.dtos.ProductoResponse;
import com.evillonl.apiportafolio.model.persistence.entities.ProductoEntity;
import com.evillonl.apiportafolio.model.persistence.repositories.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public ResponseEntity<Object> registrar(ProductoRequest request) {
        ProductoEntity producto = mapper.convertValue(request,ProductoEntity.class);
        producto.setFechaRegistro(LocalDateTime.now());
        repository.save(producto);
        return ResponseEntity.ok("ok");
    }

    @Override
    public ResponseEntity<Object> actualizar(Long id, ProductoRequest request) {

        Optional<ProductoEntity> optional = repository.findById(id);

        if (optional.isPresent()) {
            ProductoEntity producto = optional.get();
            BeanUtils.copyProperties(producto, request);
            repository.save(producto);
        }


        return ResponseEntity.ok("ok");
    }

    @Override
    public ResponseEntity<Object> consultar() {
        List<ProductoEntity> result = repository.findAll();
        List<ProductoResponse> responses = result.stream().map(ob -> mapper.convertValue(ob, ProductoResponse.class)).toList();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Object> consultarPorId(Long id) {
        Optional<ProductoEntity> optional = repository.findById(id);
        return ResponseEntity.ok(mapper.convertValue(optional.get(), ProductoResponse.class));
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("ok");
    }

}
