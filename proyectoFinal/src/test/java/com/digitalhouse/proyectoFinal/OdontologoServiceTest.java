package com.digitalhouse.proyectoFinal;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Servicio.OdontologoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    @Test
    public void crearTablaOdontologo() throws SQLException, ClassNotFoundException {
        odontologoService.crearTabla();
    }
    @Test
    public void guardarOdontologo(){
        Odontologo odo1 = new Odontologo(1234,"Fernando","Conil");
        Odontologo odo2 = new Odontologo(2345,"Brian","Mermelstein");
        odontologoService.guardar(odo1);
    }
}
