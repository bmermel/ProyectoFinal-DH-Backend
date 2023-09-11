package com.digitalhouse.proyectoFinal.Controller;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/odontologos")
public class OdontologoController{
    @Autowired
    private OdontologoService service;
    @GetMapping("/listar")
    public ResponseEntity<Object> listarOdontologos(){
        List<OdontologoDTO> lista = service.listarTodos();
        if(lista.size() == 0){
            return new ResponseEntity<>("No hay odontologos para mostrar", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Object> buscar(@PathVariable int id){
        OdontologoDTO odontologo = service.buscar(id);
        if(odontologo == null){
            return new ResponseEntity<>("No existe el odontologo seleccionado", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(odontologo,HttpStatus.OK);
        }
    }
    @PostMapping("/crear")
    public ResponseEntity<Object> crearOdontologo(@RequestBody OdontologoDTO odontoloDTO){
        if(service.crearOdontologo(odontoloDTO)){
            return new ResponseEntity<>("Guardado",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("El odontologo que desea guardar ya existe",HttpStatus.ALREADY_REPORTED);
    }
    @GetMapping("/borrar/{id}")
    public ResponseEntity<Object> borrarOdontologo(@PathVariable int id){
        if(service.borrarOdontologo(id)){
            return new ResponseEntity<>("Odontologo borrado con éxito",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("No éxiste el odontólogo que se desea borrar",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Object> actualizarOdontologo(@RequestBody OdontologoDTO odontologo){
        if(service.actualizarOdontologo(odontologo)){
            return new ResponseEntity<>("Datos actualizados para el odontologo con id = " + odontologo.getId(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("El odontologo solicitado no existe",HttpStatus.NOT_FOUND);
        }
    }
}
