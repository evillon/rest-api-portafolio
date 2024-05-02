package com.evillonl.apiportafolio.utils;

import lombok.extern.log4j.Log4j2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Log4j2
public class Utils {

    public static String encryptPassword(String clave){
        try {
            log.info("clave: {}", clave);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(clave.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);

            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }

            log.info("clave hash: {}",hexString);
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("Error al codificar la contraseña: " + e.getMessage());
        }
        return null;
    }

}
