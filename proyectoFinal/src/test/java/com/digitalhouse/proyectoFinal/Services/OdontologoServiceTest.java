package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    private Odontologo odontologo;

    @BeforeEach
    public void setUp() {
        odontologo = new Odontologo();
        odontologo.setNombre("Tomas");
        odontologo.setApellido("Dozo");
        odontologo.setMatricula("21545");
        final OdontologoRepository repository;


    }
    @Test
    void buscar() {
        Boolean odontologoBuscado = odontologoService.borrarOdontologo(3);
        assertTrue(odontologoBuscado);
    }

    @Test
    void crearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Tomas");
        odontologoDTO.setApellido("Dozo");
        odontologoDTO.setMatricula("A2KE2000");
        //este metodo devuelve boolean true si pudo crearlo, por eso se verificacon assertTrue
        Boolean odontologoGuardado = odontologoService.crearOdontologo(odontologoDTO);
        assertTrue(odontologoGuardado);
    }

    @Test
    void buscarMatricula() {
        odontologo = new Odontologo();
        odontologo.setNombre("Tomas");
        odontologo.setApellido("Dozo");
        odontologo.setMatricula("21545");
        OdontologoDTO odontologoBuscado = odontologoService.buscar(1);
        assertNotNull(odontologoBuscado);
    }

    @Test
    void borrarOdontologo() {
        //este metodo devuelve boolean true si pudo crearlo, por eso se verificacon assertTrue
        Boolean odontologoBorrado = odontologoService.borrarOdontologo(1);
        assertTrue(odontologoBorrado);
    }

    @Test
    void actualizarOdontologo() {
        OdontologoDTO odontologoNuevo = new OdontologoDTO();
        odontologoNuevo.setId(999999999);
        odontologoNuevo.setNombre("Martin");
        odontologoNuevo.setApellido("Lobos");
        odontologoNuevo.setMatricula("M008");
        Boolean odontologoActualizado = odontologoService.actualizarOdontologo(odontologoNuevo);
        assertTrue(odontologoActualizado);
    }

    @Test
    void listarTodos() {
        assertNotNull(odontologoService.listarTodos());
    }
}