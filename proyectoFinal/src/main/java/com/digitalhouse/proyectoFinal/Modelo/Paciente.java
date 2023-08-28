package com.digitalhouse.proyectoFinal.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Date fechaAlta;
}
