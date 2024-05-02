package com.evillonl.apiportafolio.controller;

import com.evillonl.apiportafolio.model.dtos.ProductoRequest;
import com.evillonl.apiportafolio.model.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping
    public ResponseEntity<Object> adicionar(@RequestBody ProductoRequest request){
        return service.registrar(request);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody ProductoRequest request){
        return service.actualizar(id, request);
    }
    @GetMapping
    public ResponseEntity<Object> consultar(){
        return service.consultar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> consultarPorId(@PathVariable Long id){
        return service.consultarPorId(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminarPorId(@PathVariable Long id){
        return service.eliminarPorId(id);
    }

}
