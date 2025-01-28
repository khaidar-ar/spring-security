package com.trial.spring_security.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(c -> {
            c.realmName("CUSTOM_ENTRY_POINT");
            c.authenticationEntryPoint(new AuthenticationEntryPoint() {

                @Override
                public void commence(HttpServletRequest request, HttpServletResponse response,
                        AuthenticationException authException) throws IOException, ServletException {
                    response.addHeader("message", "custom entry point");
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                }
            });
        })
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }

}
