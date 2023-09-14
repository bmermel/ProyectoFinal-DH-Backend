package com.digitalhouse.proyectoFinal.DTO;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnoDTO {
    private int id;
    private LocalDate fecha;
    private String hora;
    private String idOdontologo;
    private String idPaciente;
}
