package com.trial.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.trial.spring_security.filter.AuthLoggingFilter;
import com.trial.spring_security.filter.RequestValidationFilter;
import com.trial.spring_security.filter.StaticAuthFilter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final StaticAuthFilter staticAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(
                staticAuthFilter,
                BasicAuthenticationFilter.class)
                // .addFilterAfter(new AuthLoggingFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return http.build();
    }

}
