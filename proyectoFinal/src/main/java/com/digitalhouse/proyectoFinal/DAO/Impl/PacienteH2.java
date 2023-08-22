package com.digitalhouse.proyectoFinal.DAO.Impl;

import com.digitalhouse.proyectoFinal.DAO.ModeloDAO;
import com.digitalhouse.proyectoFinal.Modelo.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class PacienteH2 implements ModeloDAO {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Boolean guardar(Object o) {
        return null;
    }

    @Override
    public List listarTodos() {
        return null;
    }

    @Override
    public Boolean listar(int id) {
        return null;
    }

    @Override
    public Boolean actualizar(int id) {
        return null;
    }

    @Override
    public Boolean borrar(int id) {
        return null;
    }

    //private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();



}
