package com.digitalhouse.proyectoFinal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String email;
    private String usuario;
    private String contrasena;
    private String rol;

//    private Paciente paciente;
}
