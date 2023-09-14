package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private final OdontologoRepository repository;
    @Autowired
    public OdontologoService(OdontologoRepository repository){this.repository = repository;}

    public OdontologoDTO buscar(Integer id){
        Optional<Odontologo> odontologo = repository.findById(id);
        if(odontologo.isPresent()){
            return mapper.convertValue(odontologo.get(),OdontologoDTO.class);
        }else{
            return null;
        }
    }
    public Boolean crearOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        Optional<Odontologo> busqueda = repository.findByMatricula(odontologo.getMatricula());
        if(busqueda.isPresent()){
            LOGGER.warn("Ya se encuentra registrado un odontologo con la matricula" + odontologo.getMatricula());
            return false;
        }else{
            repository.save(odontologo);
            return true;
        }
    }
    public OdontologoDTO buscarMatricula(String matricula){
        Optional<Odontologo> odontologo = repository.findByMatricula(matricula);
        return mapper.convertValue(odontologo,OdontologoDTO.class);
    }


    public Boolean borrarOdontologo(int id){
        OdontologoDTO aux = this.buscar(id);
        if(aux == null){
            LOGGER.error("El odontologo con id " + id +" no existe");
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

    public Boolean actualizarOdontologo(OdontologoDTO odontologoDTO){
        OdontologoDTO aux = this.buscar(odontologoDTO.getId());
        if (aux == null) {
            LOGGER.error("No existe un odontologo con id " + odontologoDTO.getId() + ".");
            return false;
        } else {
            odontologoDTO.setId(aux.getId());
            Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
            repository.save(odontologo);
            return true;
        }
    }

    public List<OdontologoDTO> listarTodos(){
        List lista = repository.findAll();
        return lista;
    }
}
