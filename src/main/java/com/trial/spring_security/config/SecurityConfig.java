package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .addFilterBefore(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return http.build();
    }

}
