package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.digitalhouse.proyectoFinal.Utils.SQLQueries;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
@Repository
public class OdontologoDAOH2 implements ModeloDAO<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";

    public OdontologoDAOH2(){ }

    @Override
    public void crearTabla() throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        Class.forName(DB_JDBC_DRIVER);
        conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        pstmt = conexion.prepareStatement(SQLQueries.CREAR_TABLA_ODONTOLOGOS);
        pstmt.execute();
        pstmt.close();
        LOGGER.info("Tabla inicializada");
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
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
            return odontologo;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Odontologo> listarTodos() {
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
                //P R E G U N T A R
                // Usamos Odontologo u OdontologoDTO?
                Odontologo odontologo = new Odontologo(matricula,nombre,apellido);
                odontologosList.add(odontologo);
            }
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return odontologosList;
    }

    @Override
    public Odontologo listar(Integer id) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        //Iniciamos conexion
        Class.forName(DB_JDBC_DRIVER);
        conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        pstmt = conexion.prepareStatement(SQLQueries.TRAER_ODONTOLOGO);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        int matricula = rs.getInt("MATRICULA");
        String nombre = rs.getString("NOMBRE");
        String apellido = rs.getString("APELLIDO");
        Odontologo odontologo = new Odontologo(matricula,nombre,apellido);
        pstmt.close();
        return odontologo;
    }

    @Override
    public Boolean actualizar(Odontologo odontologo) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.ACTUALIZAR_ODONTOLOGO);
            pstmt.setString(1,odontologo.getNombre());
            pstmt.setString(2,odontologo.getApellido());
            pstmt.setInt(3,odontologo.getMatricula());
            pstmt.execute();
            pstmt.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean borrar(Integer id) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try {
            LOGGER.info("Borrando odontologo");
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.BORRAR_ODONTOLOGO);
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            LOGGER.info("Odontologo borrado");
            return true;
        }catch (Exception e){
            LOGGER.error(e);
            return false;
        }
    }

}
