package com.SpringSecurity.TeoriaSecurity1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration // 🔹 Indica que esta clase es una configuración de Spring.
@EnableWebSecurity // 🔹 Habilita la seguridad web en la aplicación.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/index").permitAll() // 🔹 Permite acceso sin autenticación a "/api/v1/index".
                        .anyRequest().authenticated() // 🔹 Todas las demás rutas requieren autenticación.
                )
                .formLogin(form -> form
                        .successHandler(successHandler()) // 🔹 Define qué hacer después de un login exitoso.
                        .permitAll() // 🔹 Permite el acceso al formulario de inicio de sesión sin restricciones.
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // 🔹 Siempre crea una nueva sesión después de autenticarse.
                        .sessionFixation(sessionFixation -> sessionFixation.migrateSession()) // 🔹 Evita ataques de fijación de sesión regenerando la sesión después del login.
                        .sessionConcurrency(sessionConcurrency -> sessionConcurrency
                                .maximumSessions(1) // 🔹 Permite solo 1 sesión activa por usuario.
                                .expiredUrl("/login") // 🔹 Si la sesión expira, redirige a "/login".
                                .sessionRegistry(sessionRegistry()) // 🔹 Registra las sesiones activas.
                        )
                )
                .build();
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl(); // 🔹 Implementación para rastrear sesiones activas.
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) ->
                response.sendRedirect("/api/v1/session") // 🔹 Después de iniciar sesión, redirige al endpoint "/api/v1/session".
        );
    }
}
