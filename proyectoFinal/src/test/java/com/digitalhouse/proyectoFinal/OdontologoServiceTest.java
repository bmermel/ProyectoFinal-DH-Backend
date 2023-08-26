package com.digitalhouse.proyectoFinal;
import static org.junit.jupiter.api.Assertions.*;
import com.digitalhouse.proyectoFinal.DAO.Impl.OdontologoH2;
import com.digitalhouse.proyectoFinal.Modelo.Odontologo;
import com.digitalhouse.proyectoFinal.Servicio.OdontologoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
public class OdontologoServiceTest {
   @Test
    public void crearTabla() {
       OdontologoH2 oH2 = new OdontologoH2();
       OdontologoService odoService = new OdontologoService();
       odoService.setOdontolodoDAO(oH2);

   }
   @Test
   public void guardarOdontologo(){
       Odontologo odo1 = new Odontologo(1, "Fernando", "Conil");
       Odontologo odo2 = new Odontologo(2, "Brian", "Mermelstein");
       Odontologo odo3 = new Odontologo(3, "Cosme", "fulanito");
       OdontologoH2 oH2 = new OdontologoH2();
       OdontologoService odoService = new OdontologoService();
       odoService.setOdontolodoDAO(oH2);
       odoService.guardar(odo1);
   }
}
