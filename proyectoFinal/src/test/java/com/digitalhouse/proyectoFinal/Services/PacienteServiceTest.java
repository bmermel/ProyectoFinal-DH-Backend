package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.DomicilioDTO;
import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PacienteServiceTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PacienteService pacienteService;
    @BeforeEach
    public void setUp() {


    }

    @Test
    void guardar() throws SQLException, ClassNotFoundException {
        PacienteDTO paciente = new PacienteDTO();
        paciente.setNombre("Tomas");
        paciente.setApellido("Dozo");
        paciente.setDni("34340133");

        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setCalle("Calle falsa 123");
        domicilio.setLocalidad("CABA");
        domicilio.setProvincia("Buenos Aires");
        domicilio.setNumero("123");
        paciente.setDomicilio(domicilio);
        pacienteService.guardar(paciente);
        assertNotNull(pacienteService.buscar(paciente.getId()));

    }

    @Test
    void buscar() {
        PacienteDTO paciente = new PacienteDTO();
        paciente.setNombre("Tomas");
        paciente.setApellido("Dozo");
        paciente.setDni("34340133");

        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setCalle("Calle falsa 123");
        domicilio.setLocalidad("CABA");
        domicilio.setProvincia("Buenos Aires");
        domicilio.setNumero("123");
        paciente.setDomicilio(domicilio);
        pacienteService.buscar(paciente.getId());
        assertNotNull(pacienteService.buscar(paciente.getId()));
    }

    @SneakyThrows
    @Test
    void buscarTodos() throws SQLException, ClassNotFoundException {
        //Dado que tenemos ya pre cargados varios pacientes, directamente con el metodo assert not null estamos correctos
        assertNotNull(pacienteService.buscarTodos());
    }

    @Test
    void eliminar() throws SQLException, ClassNotFoundException {
        //dado que ya tenemos pacientes cargados y devuelve un boolean segun si se pudo hacer, con el metodo solo estamos.
        assertTrue(pacienteService.eliminar(4));
    }

    @Test
    //NO ME SALE HACER
    void actualizar() throws SQLException, ClassNotFoundException {
        PacienteDTO pacienteActualizado = new PacienteDTO();
        Paciente pacienteGuardado = new Paciente();
        pacienteGuardado.setNombre("Tomas");
        pacienteGuardado.setApellido("Dozo");
        pacienteGuardado.setDni("34340133");


        pacienteActualizado.setNombre("Martin");
        pacienteActualizado.setApellido("Lobos");
        pacienteActualizado.setDni("M008");
        pacienteService.actualizar(pacienteGuardado);
        assertEquals(pacienteGuardado.getNombre(), pacienteActualizado.getNombre());
    }
}