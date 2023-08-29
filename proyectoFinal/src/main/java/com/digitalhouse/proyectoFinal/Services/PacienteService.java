package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.Entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class PacienteService {

    private deloDAO<PaMociente> pacienteIDao;

    @Autowired
    public PacienteService(ModeloDAO<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) throws SQLException, ClassNotFoundException {
        p.setFechaAlta(new Date());
        return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Integer id) throws SQLException, ClassNotFoundException {
        return pacienteIDao.listar(id);
    }

    public List<Paciente> buscarTodos() throws SQLException, ClassNotFoundException {
        return pacienteIDao.listarTodos();
    }

    public void eliminar(Integer id) throws SQLException, ClassNotFoundException {
        pacienteIDao.borrar(id);
    }

    public void actualizar(Paciente p) throws SQLException, ClassNotFoundException {
        pacienteIDao.actualizar(p);
    }
    public void crearTabla() throws SQLException, ClassNotFoundException {
        pacienteIDao.crearTabla();
    }
}

