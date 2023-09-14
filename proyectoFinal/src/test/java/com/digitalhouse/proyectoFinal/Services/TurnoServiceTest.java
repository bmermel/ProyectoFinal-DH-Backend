package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import com.digitalhouse.proyectoFinal.Entity.Turno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class TurnoServiceTest {
    @Autowired
    TurnoService turnoService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    PacienteService pacienteService;

    @Test
    void crearTurno() {
        TurnoDTO turno = new TurnoDTO();
        turno.setFecha(LocalDate.now());
        turno.setIdPaciente(String.valueOf(Paciente.generarPacienteAleatorio().getId()));
        turno.setIdOdontologo(String.valueOf(Odontologo.generarOdontologoAleatorio().getId()));
        turnoService.crearTurno(turno);
        assertNotNull(turnoService.listarTodos());
    }

    @Test
    void borrarTurno() {
        //dado que no hay turnos pre cargados, creamos un turno para luego borrarlo, quedaría vacía la lista y se verifica que sea nulo
        TurnoDTO turno = new TurnoDTO();
        turno.setFecha(LocalDate.now());
        turno.setIdPaciente(String.valueOf(Paciente.generarPacienteAleatorio().getId()));
        turno.setIdOdontologo(String.valueOf(Odontologo.generarOdontologoAleatorio().getId()));
        turnoService.crearTurno(turno);
        turnoService.borrarTurno(turno.getId());
        assertNull(turnoService.listarTodos());


    }

    @Test
    void actualizarTurno() {
    }

    @Test
    void listarTodos() {
        TurnoDTO turno = new TurnoDTO();
        turno.setFecha(LocalDate.now());
        turno.setIdPaciente("1");
        turno.setIdOdontologo("2");
        turnoService.crearTurno(turno);
        assertNotNull(turnoService.listarTodos());
    }
}