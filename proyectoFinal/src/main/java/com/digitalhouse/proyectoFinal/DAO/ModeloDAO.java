package com.digitalhouse.proyectoFinal.DAO;

import com.digitalhouse.proyectoFinal.Modelo.OdontologoDTO;

import java.util.List;

public interface ModeloDAO <T>{
    public Boolean crearOdontologo(T t);
    public List<T> listarTodos();
    public Boolean listarOdontologos(int id);
    public Boolean actualizarOdontologo(int id);
    public Boolean borrarOdontologo(int id);
}
