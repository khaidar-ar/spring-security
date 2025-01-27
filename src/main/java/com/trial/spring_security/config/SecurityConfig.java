package com.trial.spring_security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource datasource) {
        return new JdbcUserDetailsManager(datasource);
    }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }

}
