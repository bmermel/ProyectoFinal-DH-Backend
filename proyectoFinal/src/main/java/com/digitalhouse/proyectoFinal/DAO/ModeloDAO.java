package com.digitalhouse.proyectoFinal.DAO;

import com.digitalhouse.proyectoFinal.Modelo.Odontologo;

import java.sql.SQLException;
import java.util.List;

public interface ModeloDAO <T>{
    public void crearTabla() throws ClassNotFoundException, SQLException;
    public T guardar(T t);

    public List<T> listarTodos();
    public T listar(T t) throws ClassNotFoundException, SQLException;
    public Boolean actualizar(T t);
    public Boolean borrar(T t) throws ClassNotFoundException, SQLException;
}
