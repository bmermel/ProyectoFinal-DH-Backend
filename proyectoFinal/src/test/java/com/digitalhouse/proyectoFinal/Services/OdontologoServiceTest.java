package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    private Odontologo odontologo;

    @BeforeEach
    public void setUp() {
        odontologo = new Odontologo();
        odontologo.setNombre("Jorgito");
        odontologo.setApellido("Pereyra");
        odontologo.setMatricula("9999");


    }
    @Test
    void buscar() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Tomas");
        odontologoDTO.setApellido("Dozo");
        odontologoDTO.setMatricula("999099");
        Boolean odontologoGuardado = odontologoService.crearOdontologo(odontologoDTO);
        assertTrue(odontologoGuardado);
    }

    @Test
    void crearOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Fernando");
        odontologoDTO.setApellido("Conil");
        odontologoDTO.setMatricula("9999");
        Boolean odontologoGuardado = odontologoService.crearOdontologo(odontologoDTO);
        assertTrue(odontologoGuardado);
    }

    @Test
    void buscarMatricula() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Fernando");
        odontologoDTO.setApellido("Conil");
        odontologoDTO.setMatricula("9999");
        Boolean odontologoGuardado = odontologoService.crearOdontologo(odontologoDTO);
        assertNotNull(odontologoDTO.getMatricula());
    }

    @Test
    void borrarOdontologo() {
        assertTrue(odontologoService.borrarOdontologo(1));
    }

    @Test
    void actualizarOdontologo() {
            OdontologoDTO odontologoNuevo = new OdontologoDTO();
            odontologoNuevo.setId(1);
            odontologoNuevo.setNombre("Martin");
            odontologoNuevo.setApellido("neono");
            odontologoNuevo.setMatricula("11111008");
            Boolean odontologoActualizado = odontologoService.actualizarOdontologo(odontologoNuevo);
            assertTrue(odontologoActualizado);
    }

    @Test
    void listarTodos(){
        assertNotNull(odontologoService.listarTodos());
    }
}