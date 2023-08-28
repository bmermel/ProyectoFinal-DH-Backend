package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import com.digitalhouse.proyectoFinal.Modelo.Paciente;
import com.digitalhouse.proyectoFinal.Utils.SQLQueries;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class PacienteDAOH2 implements ModeloDAO<Paciente> {

    private final Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";

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
    public Paciente guardar(Paciente paciente) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try{
            // 1- Conectamos con la base de datos
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            //2- Creamos la query
            pstmt = conexion.prepareStatement(SQLQueries.INSERT_CUSTOM_PACIENTE);
            pstmt.setInt(1,paciente.getId());
            pstmt.setString(2, paciente.getDni());
            pstmt.setString(3, paciente.getNombre());
            pstmt.setString(4, paciente.getApellido());
            pstmt.setString(5, paciente.getDomicilio());
            pstmt.setDate(6, (Date) paciente.getFechaAlta());
            //3- Enviamos la query
            pstmt.execute();
            pstmt.close();
            return paciente;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Paciente> listarTodos() {
        List<Paciente> pacienteList = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.TRAER_TODOS_PACIENTES);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ID");
                String dni = rs.getString("DNI");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                String domicilio = rs.getString("DOMICILIO");
                Date fechaAlta = rs.getDate("FECHAALTA");
                Paciente paciente = new Paciente(id,dni,nombre,apellido,domicilio,fechaAlta);
                pacienteList.add(paciente);
            }
            pstmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pacienteList;
    }

    @Override
    public Paciente listar(Integer id) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Class.forName(DB_JDBC_DRIVER);
        conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        pstmt = conexion.prepareStatement(SQLQueries.TRAER_PACIENTE);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();

        String dni = rs.getString("DNI");
        String nombre = rs.getString("NOMBRE");
        String apellido = rs.getString("APELLIDO");
        String domicilio = rs.getString("DOMICILIO");
        Date fechaAlta = rs.getDate("FECHAALTA");
        Paciente paciente = new Paciente(id,dni,nombre,apellido,domicilio,fechaAlta);
        pstmt.close();
        return paciente;
    }

    @Override
    public Boolean actualizar(Paciente paciente) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {  //consultar a fer
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.ACTUALIZAR_PACIENTE);
            pstmt.setString(1,paciente.getDni());
            pstmt.setString(2,paciente.getNombre());
            pstmt.setString(3,paciente.getApellido());
            pstmt.setString(4, paciente.getDomicilio());
            pstmt.setDate(5, (Date) paciente.getFechaAlta());
            pstmt.setInt(6,paciente.getId());

            pstmt.execute();
            pstmt.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public Boolean borrar(Integer id) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try {
            LOGGER.info("Borrando paciente");
            Class.forName(DB_JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            pstmt = conexion.prepareStatement(SQLQueries.BORRAR_PACIENTE);
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            LOGGER.info("Paciente borrado");
            return true;
        }catch (Exception e){
            LOGGER.error(e);
            return false;
        }
    }
}
