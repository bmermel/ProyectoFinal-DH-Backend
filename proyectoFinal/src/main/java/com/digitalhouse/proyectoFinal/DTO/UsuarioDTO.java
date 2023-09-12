package com.digitalhouse.proyectoFinal.DTO;

import com.digitalhouse.proyectoFinal.Entity.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioDTO {

        private Integer id;
        private String email;
        private String usuario;
        private String contrasena;
        private Set<Rol> roles = new HashSet<>();

    }

