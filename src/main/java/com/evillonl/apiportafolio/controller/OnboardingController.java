package com.evillonl.apiportafolio.controller;

import com.evillonl.apiportafolio.model.dtos.RegistroRequest;
import com.evillonl.apiportafolio.model.service.OnboardingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/onboard")
@Log4j2
public class OnboardingController {

    @Autowired
    private OnboardingService service;

    @PostMapping
    public ResponseEntity<Object> registro(@RequestBody RegistroRequest request){
        log.info("request: {}", request);
        return service.registro(request);
    }


}
