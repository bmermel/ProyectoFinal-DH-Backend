package com.digitalhouse.proyectoFinal.Servicio;

import com.digitalhouse.proyectoFinal.DAO.Impl.OdontologoH2;
import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class OdontologoService {
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);
   @Autowired
   @Qualifier("OdontologoH2")
    private ModeloDAO odontolodoDAO;

    public void setOdontolodoDAO(@Qualifier("OdontologoH2") ModeloDAO odontolodoDAO) {
        this.odontolodoDAO = odontolodoDAO;
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
