package com.digitalhouse.proyectoFinal.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UsuarioController {
 /*   @Autowired
    private UsuarioService service;
    @PostMapping("/registrar")
    public ResponseEntity<Object> crearUsuario(@RequestBody User usuarioDTO){
        if(service.crearUsuario(usuarioDTO)){
            return new ResponseEntity<>("Guardado", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("El usuario que desea guardar ya existe",HttpStatus.ALREADY_REPORTED);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> borrarUsuario(@PathVariable String email) throws SQLException, ClassNotFoundException {
        if(service.eliminar(email)){
            return new ResponseEntity<>("Usuario borrado con éxito",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("No éxiste el usuario que se desea borrar",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable String email) throws SQLException, ClassNotFoundException {
        Optional<Usuario> usuario = service.buscarPorEmail(email);
        if(usuario == null){
            return new ResponseEntity<>("No existe el usuario seleccionado",HttpStatus.OK);
            //return new ResponseEntity<>("No existe el paciente seleccionado", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        }

    }*/
}
