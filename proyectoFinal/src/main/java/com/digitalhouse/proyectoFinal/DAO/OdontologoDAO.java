package com.digitalhouse.proyectoFinal.DAO;

import com.digitalhouse.proyectoFinal.Modelo.OdontologoDTO;
import com.digitalhouse.proyectoFinal.Servicio.OdontologoService;

import java.util.List;
import java.util.logging.Logger;

public interface OdontologoDAO {
    public Boolean crearOdontologo(OdontologoDTO odontologo);
    public List<OdontologoDTO> listarTodos();
    public Boolean listarOdontologos(int id);
    public Boolean actualizarOdontologo(int id);
    public Boolean borrarOdontologo(int id);
}
