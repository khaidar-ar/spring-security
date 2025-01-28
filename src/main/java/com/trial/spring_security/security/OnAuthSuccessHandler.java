package com.trial.spring_security.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OnAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var auth = authorities.stream()
                .filter(a -> a.getAuthority().equals("READ"))
                .findFirst();
        if (auth.isPresent())
            response.sendRedirect("/hello");
        else
            response.sendRedirect("/errors");
    }

}
