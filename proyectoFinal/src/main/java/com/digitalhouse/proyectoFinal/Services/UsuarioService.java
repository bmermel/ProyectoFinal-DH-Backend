package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.UsuarioDTO;
import com.digitalhouse.proyectoFinal.Entity.Usuario;
import com.digitalhouse.proyectoFinal.Repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UsuarioService {
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
    private static final ObjectMapper mapper = new ObjectMapper();



    private UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public Boolean crearUsuario(UsuarioDTO userDto){
        Usuario usuario = mapper.convertValue(userDto,Usuario.class);
        Optional<Usuario> busqueda = repository.findById(usuario.getEmail());
        if(busqueda.isPresent()){
            LOGGER.warn("Ya se encuentra registrado un usuario" + usuario.getUsuario());
            return false;
        }else{
            repository.save(usuario);
            return true;
        }
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        Optional<Usuario> usuario = repository.findById(email);
        if(usuario.isPresent()){
            return usuario;
        }else{
            LOGGER.info("No se encontro el usuario");
            return null;
        }
    }



    public Boolean eliminar(String email) throws SQLException, ClassNotFoundException {
        if(repository.findById(email) == null){
            LOGGER.error("El usuario con email " + email +" es inexistente");
            return false;
        }else{
            repository.deleteById(email);
            return true;
        }
    }
}
