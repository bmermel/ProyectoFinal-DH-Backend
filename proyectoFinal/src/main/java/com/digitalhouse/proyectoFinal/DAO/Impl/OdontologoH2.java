package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import com.digitalhouse.proyectoFinal.Modelo.OdontologoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.digitalhouse.proyectoFinal.Utils.SQLQueries;
import org.apache.log4j.Logger;
public class OdontologoH2 implements ModeloDAO {
    private Logger LOGGER = Logger.getLogger(OdontologoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";


    @Override
    public Boolean crearOdontologo(Object o) {
        Odontologo odontologo = (Odontologo) o;
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try{
            // 1- Conectamos con la base de datos
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            //2- Creamos la query
            pstmt = conexion.prepareStatement(SQLQueries.INSERT_CUSTOM_ODONTOLOGO);
            pstmt.setInt(1,odontologo.getMatricula());
            pstmt.setString(2, odontologo.getNombre());
            pstmt.setString(3,odontologo.getApellido());
            //3- Enviamos la query
            pstmt.execute();
            pstmt.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologosList = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.TRAER_TODOS_ODONTOLOGOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int matricula = rs.getInt("MATRICULA");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                Odontologo odontologo = new Odontologo();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
