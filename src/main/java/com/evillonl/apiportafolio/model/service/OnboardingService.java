package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.RegistroRequest;
import org.springframework.http.ResponseEntity;

public interface OnboardingService {


    ResponseEntity<Object> registro(RegistroRequest request);
}
