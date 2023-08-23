package com.digitalhouse.proyectoFinal.DAO;

import java.util.List;

public interface ModeloDAO <T>{
    public T guardar(T t);
    public List<T> listarTodos();
    public T listar(T t);
    public Boolean actualizar(T t);
    public Boolean borrar(T t);
}
