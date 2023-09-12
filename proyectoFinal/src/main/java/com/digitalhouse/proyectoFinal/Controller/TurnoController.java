package com.digitalhouse.proyectoFinal.Controller;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Services.OdontologoService;
import com.digitalhouse.proyectoFinal.Services.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/turnos")
public class TurnoController {
    private final Logger LOGGER = Logger.getLogger(TurnoController.class);

    @Autowired
    private TurnoService turnoService;
    @PostMapping("/crear")
    public ResponseEntity<Object> crearTurno(@RequestBody TurnoDTO turnoDTO) throws SQLException, ClassNotFoundException {
        LOGGER.info("Info recibida:  " + turnoDTO);
        if (turnoDTO != null) {
            turnoService.crearTurno(turnoDTO);
            return ResponseEntity.ok("Turno Creado correctamente");
        }else{
            LOGGER.error("ERROR al crear un turno");
            return (ResponseEntity<Object>) ResponseEntity.badRequest();
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<Object> listarTurnos(){
        List<TurnoDTO> lista = turnoService.listarTodos();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> borrarTurno(@PathVariable Integer id){
        turnoService.borrarTurno(id);
        return ResponseEntity.ok("Turno borrado");
    }

}
