package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
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
import java.util.Optional;

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
    public Boolean crearTurno(TurnoDTO turnoDTO) {
        Turno turno = new Turno();
        LocalDate fecha = turnoDTO.getFecha();
        LocalTime hora = LocalTime.parse(turnoDTO.getHora());
        turno.setFecha(fecha);
        turno.setHora(hora);
        Integer idOdontologo = Integer.parseInt(turnoDTO.getIdOdontologo());
        Integer idPaciente = Integer.parseInt(turnoDTO.getIdPaciente());

        repository.save(turno);
        OdontologoDTO odontologoDTO = odontologoService.buscar(idOdontologo);
        Paciente paciente = pacienteService.buscar(idPaciente);
        if(odontologoDTO != null && paciente != null) {
            turno.setOdontologo(mapper.convertValue(odontologoDTO, Odontologo.class));
            turno.setPaciente(paciente);
            repository.save(turno);
            return true;
        }else{
            return false;
        }
    }
    public Boolean borrarTurno(int id){
            repository.deleteById(id);
            return true;
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
