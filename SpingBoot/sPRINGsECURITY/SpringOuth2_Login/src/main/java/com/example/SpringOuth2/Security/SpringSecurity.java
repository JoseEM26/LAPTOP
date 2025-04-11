package com.example.SpringOuth2.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {authorizationManagerRequestMatcherRegistry
                        .requestMatchers(HttpMethod.GET , "/hello").permitAll()
                        .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
