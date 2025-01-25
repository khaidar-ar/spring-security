package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final CustomAuthProvider customAuthProvider;

    @Bean
    UserDetailsService userDetailsService() {
        var user = User
                .withUsername("user-1")
                .password("{noop}12345")
                .authorities("READ")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authenticationProvider(customAuthProvider);
        http.authorizeHttpRequests(
                c -> {
                    c.requestMatchers("/java").authenticated();
                    c.requestMatchers("/hello").permitAll();
                });
        return http.build();
    }
}
