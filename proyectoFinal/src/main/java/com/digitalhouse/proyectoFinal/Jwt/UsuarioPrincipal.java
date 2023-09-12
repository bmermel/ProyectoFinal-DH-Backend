package com.digitalhouse.proyectoFinal.Jwt;

import com.digitalhouse.proyectoFinal.Entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {
    private String email;
    private String usuario;
    private String contrasena;
    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities;
        authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRol()
                .name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getEmail(),usuario.getUsuario(), usuario.getContrasena(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
