package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.trial.spring_security.security.OnAuthFailureHandler;
import com.trial.spring_security.security.OnAuthSuccessHandler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final OnAuthSuccessHandler onAuthSuccessHandler;
    private final OnAuthFailureHandler onAuthFailureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login.successHandler(onAuthSuccessHandler)
                .failureHandler(onAuthFailureHandler))
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(c -> c.anyRequest().hasAnyAuthority("ROLE_ADMIN"));
        return http.build();
    }

}
