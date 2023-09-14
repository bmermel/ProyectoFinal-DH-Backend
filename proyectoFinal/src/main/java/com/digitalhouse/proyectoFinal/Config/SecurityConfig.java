package com.digitalhouse.proyectoFinal.Config;

import com.digitalhouse.proyectoFinal.Jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import lombok.RequiredArgsConstructor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf ->
                        csrf
                                .disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                //.requestMatchers(new AntPathRequestMatcher("/auth/login")).authenticated()
                                .requestMatchers(new AntPathRequestMatcher("/auth/register")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/login.html")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/admin-dashboard.html")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/user-dashboard.html")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/listaOdontologos.html")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/listaPacientes.html")).permitAll()
                                .anyRequest().permitAll()
                )
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }

}
