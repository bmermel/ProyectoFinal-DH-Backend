package com.digitalhouse.proyectoFinal.Controller;

import com.digitalhouse.proyectoFinal.DTO.CrearPacienteDTO;
import com.digitalhouse.proyectoFinal.DTO.DomicilioDTO;
import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
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
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pacientes")
public class        PacienteController {
    //private static final ObjectMapper mapper = new ObjectMapper();

    private final Logger LOGGER = Logger.getLogger(PacienteController.class);
    private final PacienteService pacienteService;
    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/crear")
    public void crearPaciente(@RequestBody PacienteDTO request) throws SQLException, ClassNotFoundException {
        // Crea el objeto Domicilio a partir de los datos del JSON
        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setCalle(request.getDomicilio().getCalle());
        domicilio.setNumero(request.getDomicilio().getNumero());
        domicilio.setLocalidad(request.getDomicilio().getLocalidad());
        domicilio.setProvincia(request.getDomicilio().getProvincia());
        request.setDomicilio(domicilio);
        pacienteService.guardar(request);
    }

    @PutMapping("/actualizar")
    public void actualizarPaciente(@RequestBody PacienteDTO request) {
        LOGGER.info("Me llego:  " + request);
        try {

            pacienteService.actualizar(objectMapper.convertValue(request,Paciente.class));
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Ocurrio un error al actualizar el paciente", e);

        }
    }
    @GetMapping("/listar")
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
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Object> buscarPaciente(@PathVariable Integer id) throws SQLException, ClassNotFoundException {
        Paciente paciente = pacienteService.buscar(id);
        if(paciente == null){
            return new ResponseEntity<>("No existe el paciente seleccionado",HttpStatus.OK);
            //return new ResponseEntity<>("No existe el paciente seleccionado", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(paciente,HttpStatus.OK);
        }

    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> borrarPaciente(@PathVariable int id) throws SQLException, ClassNotFoundException {
        if(pacienteService.eliminar(id)){
            return new ResponseEntity<>("Paciente borrado con éxito",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("No éxiste el paciente que se desea borrar",HttpStatus.NOT_FOUND);
        }
    }

}
