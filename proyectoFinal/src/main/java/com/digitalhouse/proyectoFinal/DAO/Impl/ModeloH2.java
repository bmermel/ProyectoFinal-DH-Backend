package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.OdontologoDTO;

import java.sql.*;
import java.util.List;
import org.apache.log4j.Logger;
public class ModeloH2 implements ModeloDAO {

    private final Logger LOGGER = Logger.getLogger(ModeloH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";

    @Override
    public Boolean crearOdontologo(OdontologoDTO odontologo) {
        Connection conecxion = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            conecxion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            // creamos la query que se enviará
            pstmt = conecxion.prepareStatement();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<OdontologoDTO> listarTodos() {
        return null;
    }

    @Override
    public Boolean listarOdontologos(int id) {
        return null;
    }

    @Override
    public Boolean actualizarOdontologo(int id) {
        return null;
    }

    @Override
    public Boolean borrarOdontologo(int id) {
        return null;
    }
}
