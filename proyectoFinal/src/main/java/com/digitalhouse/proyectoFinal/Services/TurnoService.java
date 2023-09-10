package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Entity.Turno;
import com.digitalhouse.proyectoFinal.Repository.TurnoRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Setter @Getter
public class TurnoService {
    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private TurnoRepository repository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;
    @Autowired
    public TurnoService(TurnoRepository repository, PacienteService pacienteService, OdontologoService odontologoService ){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.repository = repository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }
    public void crearTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        LocalDate fecha = LocalDate.parse(turnoDTO.getFecha(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalTime hora = LocalTime.parse(turnoDTO.getHora());
        turno.setFecha(fecha);
        turno.setHora(hora);
        repository.save(turno);
    }
    public void borrarTurno(int id){
        repository.deleteById(id);
    }
    public TurnoDTO actualizarTurno(TurnoDTO turnoDTO){
       /* Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        repository.save(turno);
        TurnoDTO turnoActualizado = mapper.convertValue(turno,TurnoDTO.class);*/
        return turnoDTO;

    }
    public List listarTodos(){
        return (List) repository.findAll();
    }


}
