package com.nexus.nexus_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/cliente/createClient",
                                "/cliente/getClient/**",
                                "/cliente/editClient/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    /* Após implementar o JWT no projeto..........
                .requestMatchers(
                        "/auth/login",
                                "/cliente/createClient"
                   ).permitAll()
                .anyRequest().authenticated() */

}