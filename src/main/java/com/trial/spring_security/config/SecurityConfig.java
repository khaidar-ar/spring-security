package com.trial.spring_security.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.trial.spring_security.entity.User;
import com.trial.spring_security.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("john doe")
                .password("{noop}12345")
                .authority("READ")
                .build();
        List<UserDetails> users = List.of(user);
        return new UserService(users);
    }

}
