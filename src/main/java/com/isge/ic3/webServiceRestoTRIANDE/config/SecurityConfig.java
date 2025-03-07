package com.isge.ic3.webServiceRestoTRIANDE.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Désactive la protection CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Permet l'accès à toutes les routes sans authentification
                        .anyRequest().permitAll()  // Autorise toutes les autres requêtes
                ).headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();  // Retourne la configuration
    }
}
