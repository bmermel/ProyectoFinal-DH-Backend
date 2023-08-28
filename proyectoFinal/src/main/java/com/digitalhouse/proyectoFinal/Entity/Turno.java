package com.digitalhouse.proyectoFinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private int id;
    private Date fecha;
    private Odontologo odontologo;
    private Paciente paciente;
}
