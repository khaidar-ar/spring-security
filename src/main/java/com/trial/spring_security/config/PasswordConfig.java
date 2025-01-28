package com.trial.spring_security.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.trial.spring_security.entity.User;
import com.trial.spring_security.service.UserDetailsServiceImpl;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(
                List.of(User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("12345"))
                        .build(),
                        User.builder()
                                .username("john")
                                .password(passwordEncoder().encode("password"))
                                .build()));
    }

}
