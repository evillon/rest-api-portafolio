package com.evillonl.apiportafolio.controller;

import com.evillonl.apiportafolio.model.dtos.LoginRequest;
import com.evillonl.apiportafolio.model.service.AutenticacionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/autenticacion")
@Log4j2
public class AutenticacionController {

    @Autowired
    private AutenticacionService service;

    @PostMapping
    ResponseEntity<Object> login(@RequestBody LoginRequest request){
        log.info("request:{}", request);
        return service.login(request);
    }

    @PutMapping
    ResponseEntity<Object> logout(){
        return service.logout();
    }

    @GetMapping
    ResponseEntity<Object> menu(){
        return service.menu();
    }

}
