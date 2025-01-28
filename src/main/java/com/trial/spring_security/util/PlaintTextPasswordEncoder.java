package com.trial.spring_security.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PlaintTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }

    public String hashSHA512(String rawPassword) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] diggested = md.digest(rawPassword.getBytes());
            for (int i = 0; i < diggested.length; i++) {
                result.append(Integer.toHexString(0XFF & diggested[i]));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Bad Algorithm");
        }
        return result.toString();
    }

}
