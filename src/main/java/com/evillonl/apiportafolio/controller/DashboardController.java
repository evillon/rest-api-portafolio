package com.evillonl.apiportafolio.controller;

import com.evillonl.apiportafolio.model.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    ResponseEntity<Object> consulta(@RequestParam Integer estado){
        return service.consulta(estado);
    }

}
