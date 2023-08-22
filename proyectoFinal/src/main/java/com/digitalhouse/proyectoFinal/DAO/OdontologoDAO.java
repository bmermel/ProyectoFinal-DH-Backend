package com.digitalhouse.proyectoFinal.DAO;

import com.digitalhouse.proyectoFinal.Servicio.OdontologoService;

import java.util.List;
import java.util.logging.Logger;

public interface OdontologoDAO {
    public Boolean crearOdontologo();
    public Boolean listarTodos();
    public List<> listarOdontologos();
    public Boolean actualizarOdontologo();
    public Boolean borrarOdontologo();
}
