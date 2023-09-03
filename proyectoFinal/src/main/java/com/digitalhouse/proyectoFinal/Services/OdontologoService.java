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

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private OdontologoRepository repository;
    @Autowired
    public OdontologoService(OdontologoRepository repository){this.repository = repository;}


    public Boolean crearOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        Odontologo busqueda = repository.findByMatricula(odontologo.getMatricula());
        if(busqueda != null){
            LOGGER.warn("Ya se encuentra registrado un odontologo con la matricula" + odontologo.getMatricula());
            return false;
        }else{
            repository.save(odontologo);
            return true;
        }
    }


    public Boolean borrarOdontologo(int id){
        Optional<Odontologo> odontologo = repository.findById(id);
        if(odontologo == null){
            LOGGER.error("El odontologo con id " + id +" no existe");
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

    public OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        repository.save(odontologo);
        return odontologoDTO;
    }
    public OdontologoDTO buscarOdontologo(Integer id){
        return mapper.convertValue(repository.findById(id).get(),OdontologoDTO.class);
    }

    public List<OdontologoDTO> listarTodos(){
        List lista = repository.findAll();
        return lista;
    }
}
