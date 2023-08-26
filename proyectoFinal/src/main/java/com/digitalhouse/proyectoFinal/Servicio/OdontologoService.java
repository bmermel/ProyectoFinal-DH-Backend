package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    private static Logger LOGGER = Logger.getLogger(OdontologoService.class);
    private ModeloDAO odontolodoDAO;
    public ModeloDAO setOdontolodoDAO(ModeloDAO<Odontologo> odontolodoDAO){
        return this.odontolodoDAO = odontolodoDAO;
    }
    public void crearTabla() throws SQLException, ClassNotFoundException {
        odontolodoDAO.crearTabla();
    }
    public void guardar(Odontologo odontologo){
        odontolodoDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontolodoDAO.listarTodos();
    }
    public Odontologo listar(Odontologo odontologo) throws ClassNotFoundException, SQLException{
        return (Odontologo) odontolodoDAO.listar(odontologo);
    }
    public void actualizar(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        odontolodoDAO.listar(odontologo);
    }
    public void borrar(Odontologo odontologo) throws ClassNotFoundException, SQLException{
        odontolodoDAO.borrar(odontologo);
    }
}
