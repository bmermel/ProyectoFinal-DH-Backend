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
    void buscarTodos() {

    }

    @Test
    void eliminar() {
    }

    @Test
    void actualizar() {
    }
}