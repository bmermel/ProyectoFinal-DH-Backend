package com.digitalhouse.proyectoFinal.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ModeloDAO <T>{
    public void crearTabla() throws ClassNotFoundException, SQLException;
    public T guardar(T t) throws ClassNotFoundException, SQLException;

    public List<T> listarTodos();
    public T listar(Integer id) throws ClassNotFoundException, SQLException;
    public Boolean actualizar(T t);
    public Boolean borrar(Integer id) throws ClassNotFoundException, SQLException;
}
