package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var memory = new InMemoryUserDetailsManager();
        var john = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();
        var paul = User.withUsername("paul")
                .password("12345")
                .authorities("write")
                .build();
        memory.createUser(john);
        memory.createUser(paul);
        return memory;
    }

}
