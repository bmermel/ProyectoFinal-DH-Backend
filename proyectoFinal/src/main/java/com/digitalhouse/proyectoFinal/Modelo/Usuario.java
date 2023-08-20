package com.digitalhouse.proyectoFinal.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String usuario;
    private String contrasena;
    private String rol;
    private Paciente paciente;
}
