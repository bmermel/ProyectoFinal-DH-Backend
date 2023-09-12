package com.digitalhouse.proyectoFinal.Jwt;

import com.digitalhouse.proyectoFinal.Entity.Usuario;
import com.digitalhouse.proyectoFinal.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email).get();
        return UsuarioPrincipal.build(usuario);
    }

}
