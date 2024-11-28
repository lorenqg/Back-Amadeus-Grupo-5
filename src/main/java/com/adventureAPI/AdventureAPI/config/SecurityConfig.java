package com.adventureAPI.AdventureAPI.config;

import com.adventureAPI.AdventureAPI.config.auth.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configurar CORS aquí
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no es necesario
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login", "/user/create", "/api/reports/getReports" ).permitAll() // Rutas públicas
                        .anyRequest().authenticated() // Todas las demás requieren autenticación
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // Filtro JWT

        return http.build();
    }

    // Configuración CORS personalizada
    private UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("http://localhost:*", "https://*.mi-dominio.com")); // Permite solicitudes desde tu frontend
        config.addAllowedMethod("*"); // Permite todos los métodos (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permite todas las cabeceras
        config.setAllowCredentials(true); // Permite credenciales (cookies, cabeceras de autenticación)
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
