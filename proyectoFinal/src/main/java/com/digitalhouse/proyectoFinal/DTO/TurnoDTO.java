package com.digitalhouse.proyectoFinal.DTO;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class TurnoDTO {
    private int id;
    private Date fecha;
    private Odontologo odontologo;
    private Paciente paciente;
}
