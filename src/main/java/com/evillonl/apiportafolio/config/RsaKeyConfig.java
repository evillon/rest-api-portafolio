package com.evillonl.apiportafolio.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@Getter
@Log4j2
public class RsaKeyConfig {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    @PostConstruct
    public void init() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = (RSAPublicKey) keyPair.getPublic();
            privateKey = (RSAPrivateKey) keyPair.getPrivate();
            log.trace("Clave pública: {}" , publicKey);
            log.trace("Clave privada: {}" , privateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar las claves RSA", e);
        }
    }

}
