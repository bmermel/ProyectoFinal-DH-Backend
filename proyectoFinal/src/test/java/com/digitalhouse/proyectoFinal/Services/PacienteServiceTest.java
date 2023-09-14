package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.DomicilioDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;
    @Test
    void guardar() throws SQLException, ClassNotFoundException {
        PacienteDTO paciente = new PacienteDTO();
        paciente.setId(900);
        paciente.setNombre("Tomas");
        paciente.setApellido("Dozo");
        paciente.setDni("34340133");
        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setProvincia("Buenos Aires");
        domicilio.setNumero("123");
        paciente.setDomicilio(domicilio);
        pacienteService.guardar(paciente);
        assertNotNull(pacienteService.buscar(paciente.getId()));
        PacienteDTO pacienteYaGuardado = pacienteService.guardar(paciente);
        assertNotNull(pacienteService.buscar(900));

    }

    @Test
    void buscar() {
        Paciente pacientebuscado = pacienteService.buscar(5);
        assertNotNull(pacientebuscado);
    }

    @Test
    void buscarTodos() throws SQLException, ClassNotFoundException {
        assertNotNull(pacienteService.buscarTodos());
    }

    @Test
    void eliminar() throws SQLException, ClassNotFoundException {
        assertTrue(pacienteService.eliminar(1));
    }

    @Test
    void actualizar() throws SQLException, ClassNotFoundException {
        Paciente paciente = new Paciente();
        paciente.setId(1);
        paciente.setNombre("Cosme");
        paciente.setApellido("Fulanito");
        paciente.setDni("123456789");
        Boolean pacienteActualizado = pacienteService.actualizar(paciente);
        assertTrue(pacienteActualizado);
    }
}