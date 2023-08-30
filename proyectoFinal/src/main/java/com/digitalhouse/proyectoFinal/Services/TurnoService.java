package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Turno;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import com.digitalhouse.proyectoFinal.Repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter @Getter
public class TurnoService {
    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private TurnoRepository repository;
    @Autowired
    public TurnoService(TurnoRepository repository){
        this.repository = repository;
    };
    public TurnoDTO guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        repository.save(turno);
        TurnoDTO turnoGuardoDTO = mapper.convertValue(turno,TurnoDTO.class);
        return turnoGuardoDTO;
    }
    public void borrarTurno(int id){
        repository.deleteById(id);
    }
    public TurnoDTO actualizarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        repository.save(turno);
        TurnoDTO turnoActualizado = mapper.convertValue(turno,TurnoDTO.class);
        return turnoActualizado;
    }


}
