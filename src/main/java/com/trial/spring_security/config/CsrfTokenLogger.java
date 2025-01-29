package com.trial.spring_security.config;

import java.io.IOException;

import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsrfTokenLogger implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        log.info("csrf token : " + token);
        chain.doFilter(request, response);
    }

}
