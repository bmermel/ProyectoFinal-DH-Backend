package com.digitalhouse.proyectoFinal.Controller;

import com.digitalhouse.proyectoFinal.DTO.CrearPacienteDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Services.PacienteService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final Logger LOGGER = Logger.getLogger(PacienteController.class);
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public void crearPaciente(@RequestBody CrearPacienteDTO request) {
        LOGGER.info("Info recibida:  " + request);
        try {
            pacienteService.guardar(Mapper.map(request));
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Ocurrio un error al persistir el paciente", e);

        }
    }

    @PutMapping
    public void actualizarPaciente(@RequestBody PacienteDTO request) {
        LOGGER.info("Me llego:  " + request);
        try {
            pacienteService.actualizar(Mapper.map(request));
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Ocurrio un error al actualizar el paciente", e);

        }
    }
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        LOGGER.info("Me llego: listar pacientes  ");
        ObjectMapper mapper = new ObjectMapper();
        List<PacienteDTO> response = null;
        try {
            response = mapper.convertValue(pacienteService.buscarTodos(), new TypeReference<>() {
            });
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Ocurrio un error al listar los pacientes", e);
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
