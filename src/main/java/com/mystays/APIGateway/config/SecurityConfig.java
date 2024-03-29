package com.mystays.APIGateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

import java.util.List;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${host.ui}")
    private String hostUri;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http.csrf().disable().authorizeExchange()
                .pathMatchers("/api-gateway/account/api/signup").permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .opaqueToken();
        http
                .cors().configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of(hostUri));
            configuration.setAllowedMethods(List.of("*"));
            configuration.setAllowedHeaders(List.of("*"));
            return configuration;
        });

        return http.build();

    }
}

