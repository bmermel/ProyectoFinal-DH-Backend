package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import com.digitalhouse.proyectoFinal.Modelo.Paciente;
import lombok.AllArgsConstructor;

import java.util.Date;
@AllArgsConstructor
public class TurnoService {
    private Integer id;
    private Odontologo odontologo;
    private Paciente paciente;
    private Date fecha;

}
