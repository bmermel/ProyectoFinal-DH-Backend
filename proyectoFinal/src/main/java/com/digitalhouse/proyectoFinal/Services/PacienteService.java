package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import com.digitalhouse.proyectoFinal.Repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private static final Logger LOGGER = Logger.getLogger(PacienteService.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteDTO guardar(PacienteDTO p) throws SQLException, ClassNotFoundException {

        //PacienteDTO PacienteDTO = new PacienteDTO();
        p.setFechaAlta(new Date());
        Paciente paciente = mapper.convertValue(p,Paciente.class);
        repository.save(paciente);
        return p;


    }

    public Paciente buscar(Integer id) {
        Optional<Paciente> paciente = repository.findById(id);
        if( paciente.isPresent()){
            return paciente.get();
        }else{
            LOGGER.info("No se encontro al paciente");
            return null;
        }
    }

    public List<Paciente> buscarTodos() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }

    public Boolean eliminar(Integer id) throws SQLException, ClassNotFoundException {
        Paciente aux = this.buscar(id);
        if(aux == null){
            LOGGER.error("El paciente con id " + id +" no existe");
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }


    public Boolean actualizar(Paciente p) throws SQLException, ClassNotFoundException {
        Paciente aux = this.buscar(p.getId());
        if(aux == null){
            LOGGER.error("No existe un paciente con id "+ p.getId()+".");
            return false;
        }else{
            p.setId(aux.getId());
            repository.save(p);
            return true;
        }
    }
    public void crearTabla() throws SQLException, ClassNotFoundException {
        //pacienteIDao.crearTabla();
    }
}

