package com.digitalhouse.proyectoFinal.Utils;

public class SQLQueries {
    //QUERIES PARA TABLA ODONTOLOGOS
    public static final String CREAR_TABLA_ODONTOLOGOS =
            "DROP TABLE IF EXISTS ODONTOLOGO;" +
            "CREATE TABLE ODONTOLOGO(MATRICULA INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255));";
    public static final String INSERT_CUSTOM_ODONTOLOGO = "INSERT INTO ODONTOLOGO VALUES(?,?,?);";
    public static final String TRAER_TODOS_ODONTOLOGOS = "SELECT * FROM ODONTOLOGO";
    public static final String TRAER_ODONTOLOGO = "SELECT NOMBRE, APELLIDO FROM ODONTOLOGO WHERE MATRICULA = ?";
    public static final String ACTUALIZAR_ODONTOLOGO = "UPDATE ODONTOLOGO SET NOMBRE = ?, APELLIDO = ? WHERE MATRICULA = ?;";
    public static final String BORRAR_ODONTOLOGO = "DELETE FROM ODONTOLOGO WHERE MATRICULA = ?;";

    //QUERIES PARA TABLA PACIENTES

    //QUERIES PARA TURNOS
    public static final String CREAR_TABLA_TURNOS =
            "DROP TABLE IF EXISTS TURNO;" +
            "CREATE TABLE TURNO (ID INT NOT NULL AUTO_INCREMENT,"+
            "MATRICULA INT NOT NULL," +
            "DNI INT NOT NULL,"+
            "FECHA DATETIME NOT NULL," +
            "HORA TIME NOT NULL," +
            "PRIMARY KEY (ID)," +
            "FOREIGN KEY (MATRICULA) REFERENCES ODONTOLOGO (MATRICULA),"+
            "FOREIGN KEY (DNI) REFERENCES PACIENTE (DNI));";
    public static final String INSERT_CUSTOM_TURNO = "INSERT INTO TURNO VALUES(?,?,?,?,?);";
    public static final String TRAER_TODOS_TURNOS = "SELECT * FROM TURNO";
    public static final String TRAER_TURNO = "";
    public static final String ACTUALIZAR_TURNO = "UPDATE TURNO SET MATRICULA = ?, DNI = ? , FECHA = ?, HORA = ? WHERE ID = ?;";
    public static final String BORRAR_TURNO = "DELETE FROM TURNO WHERE ID = ?;";


}
