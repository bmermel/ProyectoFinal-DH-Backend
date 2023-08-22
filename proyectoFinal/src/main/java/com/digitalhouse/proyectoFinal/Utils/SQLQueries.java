package com.digitalhouse.proyectoFinal.Utils;

public class SQLQueries {
    public static final String CREARTABLA_ODONTOLOGOS =
            "DROP TABLE IF EXISTS ODONTOLOGO;" +
            "CREATE TABLE ODONTOLOGO(MATRICULA INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255));" ;
    public static final String INSERT_CUSTOM_ODONTOLOGO = "INSERT INTO ODONTOLOGO VALUES(?,?,?);";
    public static final String TRAER_TODOS_ODONTOLOGOS = "SELECT * FROM ODONTOLOGO";
}
