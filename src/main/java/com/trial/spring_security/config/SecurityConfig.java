package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user-1")
                .password("12345")
                .authorities("READ")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
