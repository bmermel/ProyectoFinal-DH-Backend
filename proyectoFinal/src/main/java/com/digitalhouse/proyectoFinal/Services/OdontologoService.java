package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    private OdontologoRepository repository;
    @Autowired
    public OdontologoService(OdontologoRepository repository){
        this.repository = repository;
    }
    public void guardarOdontologo(Odontologo odontologo){
        repository.save(odontologo);
    }
    public void borrarOdontologo(int id){
        repository.deleteById(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        repository.save(odontologo);
    }
}
