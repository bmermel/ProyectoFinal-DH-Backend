package com.digitalhouse.proyectoFinal.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Autowired
    private AppUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

}
