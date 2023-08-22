package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private ModeloDAO<Paciente> pacienteModeloDAO;

    @Autowired

    public PacienteService(ModeloDAO<Paciente> pacienteModeloDAO) {
        this.pacienteModeloDAO = pacienteModeloDAO;
    }
    public Paciente guardar(Paciente p) {
        //p.setFechaIngreso(new Date());
        //return pacienteModeloDAO.guardar(p);
    }
    public Paciente listar(Integer id) {
        return pacienteModeloDAO.buscar(id);
    }

    public List<Paciente> listarTodos() {
        return pacienteModeloDAO.buscarTodos();
    }

    public void borrar(Integer id) {
        pacienteModeloDAO.eliminar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteModeloDAO.actualizar(p);
    }
}
