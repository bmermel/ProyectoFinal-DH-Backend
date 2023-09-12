package com.digitalhouse.proyectoFinal.JwtPlayground;

import com.digitalhouse.proyectoFinal.Entity.Usuario;
import com.digitalhouse.proyectoFinal.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuarioService.buscarPorEmail(username).get();

        if (usuario == null) throw new UsernameNotFoundException(username);

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(usuario.getRol()));

        return new User(usuario.getEmail(), usuario.getContrasena(), authorities);
    }

}
