package com.digitalhouse.proyectoFinal.DAO;

import java.util.List;

public interface ModeloDAO <T>{
    public Boolean guardar(T t);
    public List<T> listarTodos();
    public Object listar(T t);
    public Boolean actualizar(T t);
    public Boolean borrar(T t);
}
