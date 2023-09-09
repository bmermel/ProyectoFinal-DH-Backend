package com.digitalhouse.proyectoFinal.Login;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user-sequence")
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUsuarioRoles appusuarioRoles;

    public AppUser() {
    }

    public AppUser(String nombre, String username, String email, String password, AppUsuarioRoles appusuarioRoles) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appusuarioRoles = appusuarioRoles;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appusuarioRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUsuarioRoles getAppusuarioRoles() {
        return appusuarioRoles;
    }

    public void setAppusuarioRoles(AppUsuarioRoles appusuarioRoles) {
        this.appusuarioRoles = appusuarioRoles;
    }
}
