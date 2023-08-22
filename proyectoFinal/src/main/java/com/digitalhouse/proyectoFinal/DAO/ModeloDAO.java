package com.digitalhouse.proyectoFinal.DAO;

import java.util.List;

public interface ModeloDAO <T>{
    public Boolean guardar(T t);
    public List<T> listarTodos();
    public Boolean listar(int id);
    public Boolean actualizar(int id);
    public Boolean borrar(int id);
}
