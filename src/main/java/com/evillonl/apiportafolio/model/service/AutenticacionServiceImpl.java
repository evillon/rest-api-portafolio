package com.evillonl.apiportafolio.model.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.evillonl.apiportafolio.config.RsaKeyConfig;
import com.evillonl.apiportafolio.model.dtos.AutenticacionResponse;
import com.evillonl.apiportafolio.model.dtos.LoginRequest;
import com.evillonl.apiportafolio.model.persistence.entities.SessionEntity;
import com.evillonl.apiportafolio.model.persistence.entities.Usuario;
import com.evillonl.apiportafolio.model.persistence.repositories.SesionRepository;
import com.evillonl.apiportafolio.model.persistence.repositories.UsuarioRepository;
import com.evillonl.apiportafolio.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;



@Service
@Log4j2
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    private RsaKeyConfig rsa;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    @Override
    public ResponseEntity<Object> login(LoginRequest request) {
        AutenticacionResponse response = new AutenticacionResponse();

        Optional<Usuario> optional = usuarioRepository.findByUsuario(request.getUsuario());
        log.info(optional);
        if (optional.isPresent()) {
            String hash = Utils.encryptPassword(request.getClave());
            Usuario usuario = optional.get();
            log.info(usuario);
            if (Objects.nonNull(hash) && usuario.getClave().compareTo(hash) == 0) {
                if (usuario.getEstado().equals(1)) {
                    if (usuario.getFechaExpiracion().isAfter(LocalDate.now())) {
                        try {

                            RSAPublicKey publicKey = rsa.getPublicKey();
                            RSAPrivateKey privateKey = rsa.getPrivateKey();

                            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
                            String token = JWT.create()
                                    .withIssuer("auth0")
                                    .withSubject(usuario.getUsuario())

                                    .sign(algorithm)
                                    ;
                            log.info("JWT: {}" , token);
                            response.setToken(token);
                            SessionEntity entity = new SessionEntity();
                            entity.setIdUsuario(usuario.getId());
                            //entity.setToken(token);
                            entity.setFechaRegistro(LocalDateTime.now());
                            entity.setRegistradoPor(usuario.getUsuario());
                            sesionRepository.save(entity);
                            log.info(response);
                        }catch (Exception ex){
                            log.error("{}",ex.getMessage());
                        }

                    }else {
                        log.warn("la contraseña esta expirada");
                    }
                }else {
                    log.warn("el usuario no esta activo");
                }
            }else {
                log.warn("la clave no coincide");
            }
        }else {
            log.warn("no se encontro el usuario");
        }

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> logout() {
        return null;
    }

    @Override
    public ResponseEntity<Object> menu() {
        return null;
    }
}
