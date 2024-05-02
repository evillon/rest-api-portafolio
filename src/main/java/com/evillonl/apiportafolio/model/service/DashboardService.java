package com.evillonl.apiportafolio.model.service;

import org.springframework.http.ResponseEntity;

public interface DashboardService {

    ResponseEntity<Object> consulta(Integer estado);

}
