package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

public interface AutenticacionService {
    ResponseEntity<Object> login(LoginRequest request);
    ResponseEntity<Object> logout();
    ResponseEntity<Object> menu();
}
