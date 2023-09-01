package com.digitalhouse.proyectoFinal.Services;

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

    public Optional<Paciente> buscar(Integer id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    public List<Paciente> buscarTodos() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }

    public void eliminar(Integer id) throws SQLException, ClassNotFoundException {
        repository.deleteById(id);
    }

    public void actualizar(Paciente p) throws SQLException, ClassNotFoundException {
        repository.save(p);
    }
    public void crearTabla() throws SQLException, ClassNotFoundException {
        //pacienteIDao.crearTabla();
    }
}

