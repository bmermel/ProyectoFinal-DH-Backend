package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    private ModeloDAO<Odontologo> odontolodoDAO;
    @Autowired
    public OdontologoService(@Qualifier("odontologoDAOH2") ModeloDAO<Odontologo> odontolodoDAO) {
        this.odontolodoDAO = odontolodoDAO;
    }

    //SETTER
    public void setOdontolodoDAO(@Qualifier("odontologoDAOH2") ModeloDAO<Odontologo> odontolodoDAO) {
        this.odontolodoDAO = odontolodoDAO;
    }

    public void crearTabla() throws SQLException, ClassNotFoundException {
        odontolodoDAO.crearTabla();
    }
    public void guardar(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        odontolodoDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontolodoDAO.listarTodos();
    }
    public Odontologo listar(Integer id) throws ClassNotFoundException, SQLException{
        return (Odontologo) odontolodoDAO.listar(id);
    }
    public void actualizar(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        odontolodoDAO.actualizar(odontologo);
    }
    public void borrar(Integer id) throws ClassNotFoundException, SQLException{
        odontolodoDAO.borrar(id);
    }
}
