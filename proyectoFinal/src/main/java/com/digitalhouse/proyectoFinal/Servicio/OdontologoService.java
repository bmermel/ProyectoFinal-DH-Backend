package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    private ModeloDAO<Odontologo> odontolodoDAO;
    public void setOdontolodoDAO(ModeloDAO<Odontologo> odontolodoDAO){
        this.odontolodoDAO = odontolodoDAO;
    }
    public void guardar(Odontologo odontologo){
        odontolodoDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontolodoDAO.listarTodos();
    }
    public Odontologo listar(Odontologo odontologo) throws ClassNotFoundException, SQLException{
        return odontolodoDAO.listar(odontologo);
    }
    public void actualizar(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        odontolodoDAO.listar(odontologo);
    }
    public void borrar(Odontologo odontologo) throws ClassNotFoundException, SQLException{
        odontolodoDAO.borrar(odontologo);
    }
}
