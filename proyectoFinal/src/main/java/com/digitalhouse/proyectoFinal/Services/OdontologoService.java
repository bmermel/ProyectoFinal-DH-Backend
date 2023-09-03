package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private OdontologoRepository repository;
    @Autowired
    public OdontologoService(OdontologoRepository repository){this.repository = repository;}


    public OdontologoDTO guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        repository.save(odontologo);
        return odontologoDTO;
    }


    public void borrarOdontologo(int id){
        repository.deleteById(id);
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
