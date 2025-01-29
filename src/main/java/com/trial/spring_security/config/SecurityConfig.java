package com.trial.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails manager = User.withUsername("john")
                .password("12345")
                .roles("MANAGER")
                .build();
        UserDetails admin = User.withUsername("paul")
                .password("12345")
                .roles("ADMIN")
                .build();
        userDetailsManager.createUser(manager);
        userDetailsManager.createUser(admin);
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(c -> c.disable())
                .authorizeHttpRequests(a -> a.requestMatchers("/hello").hasRole("MANAGER")
                        .requestMatchers("/java").hasRole("ADMIN")
                        .anyRequest().permitAll());
        return http.build();
    }

}
