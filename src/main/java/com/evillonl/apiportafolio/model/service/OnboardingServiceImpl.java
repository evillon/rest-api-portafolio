package com.evillonl.apiportafolio.model.service;

import com.evillonl.apiportafolio.model.dtos.RegistroRequest;
import com.evillonl.apiportafolio.model.persistence.entities.Usuario;
import com.evillonl.apiportafolio.model.persistence.repositories.UsuarioRepository;
import com.evillonl.apiportafolio.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Log4j2
public class OnboardingServiceImpl implements  OnboardingService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ObjectMapper maper;

    @Override
    public ResponseEntity<Object> registro(RegistroRequest request) {
        log.info("request: {}", request);
        Usuario usuario = new Usuario();
        usuario.setUsuario(request.getUsuario());
        usuario.setClave(Utils.encryptPassword(request.getClave()));
        usuario.setCorreo(request.getCorreo());
        usuario.setIdentificacion(request.getIdentificacion());
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setRegistradoPor("ONBOARDING");
        usuario.setEstado(1);
        usuario.setFechaExpiracion(LocalDate.now().plusDays(90));
        log.info("request: {}", request);
        repository.save(usuario);
        return ResponseEntity.ok("ok");
    }

}
