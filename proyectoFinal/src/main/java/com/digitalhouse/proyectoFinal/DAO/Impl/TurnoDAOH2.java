package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Turno;
import com.digitalhouse.proyectoFinal.Utils.SQLQueries;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TurnoDAOH2 implements ModeloDAO<Turno> {
    private final Logger LOGGER = Logger.getLogger(TurnoDAOH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";

    public TurnoDAOH2() {}

    @Override
    public void crearTabla() throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Class.forName(DB_JDBC_DRIVER);
        conexion = DriverManager.getConnection(DB_URL,DB_USER,DB_URL);
        pstmt = conexion.prepareStatement(SQLQueries.CREAR_TABLA_TURNOS);
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public Turno guardar(Turno turno) {
        return null;
    }

    @Override
    public List<Turno> listarTodos() {
        return null;
    }

    @Override
    public Turno listar(Turno turno) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean actualizar(Turno turno) {
        return null;
    }

    @Override
    public Boolean borrar(Turno turno) throws ClassNotFoundException, SQLException {
        return null;
    }
}

