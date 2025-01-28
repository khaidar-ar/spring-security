package com.trial.spring_security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StaticAuthFilter implements Filter {

    @Value("${authorization.key}")
    private String AUTH_KEY;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String auth = req.getHeader("Authorization");
        if (auth.equals(AUTH_KEY)) {
            chain.doFilter(request, response);
            log.info("success authenticate using key : " + auth);
        } else {
            log.warn("unauthorized request");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

}
