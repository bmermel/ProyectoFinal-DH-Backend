package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteService {
    private ModeloDAO<Paciente> pacienteModeloDAO;

    @Autowired

    public PacienteService(ModeloDAO<Paciente> pacienteModeloDAO) {
        this.pacienteModeloDAO = pacienteModeloDAO;
    }
    public Boolean guardar(Paciente p) {
        //p.setFechaIngreso(new Date());
        if (p!= null){
            p.setFechaAlta(LocalDate.now());
            pacienteModeloDAO.guardar(p);
            System.out.println("paciente guardado");
            return true;
        }else
        {return false;}

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

    public Boolean actualizar(Paciente p) {
        return null;
                //pacienteModeloDAO.actualizar(p);

    }
}
