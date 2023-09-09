package com.digitalhouse.proyectoFinal.Services;

import com.digitalhouse.proyectoFinal.DTO.OdontologoDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.DTO.TurnoDTO;
import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import com.digitalhouse.proyectoFinal.Entity.Turno;
import com.digitalhouse.proyectoFinal.Repository.OdontologoRepository;
import com.digitalhouse.proyectoFinal.Repository.PacienteRepository;
import com.digitalhouse.proyectoFinal.Repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
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
    public TurnoService(TurnoRepository repository){
        this.repository = repository;
    };
    public TurnoDTO crearTurno(TurnoDTO turnoDTO) throws SQLException, ClassNotFoundException {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        Integer idOdontologo = turno.getOdontologo().getId();
        Integer idPaciente = turno.getPaciente().getId();
        OdontologoDTO odontologo = odontologoService.buscarOdontologo(idOdontologo);
        Paciente paciente = pacienteService.buscar(idPaciente);
        if(paciente != null && odontologo != null){
            Turno nuevoTurno = new Turno();
            nuevoTurno.setPaciente(paciente);
            nuevoTurno.setOdontologo(mapper.convertValue(odontologo,Odontologo.class));
            repository.save(nuevoTurno);
            return mapper.convertValue(nuevoTurno,TurnoDTO.class);

        }else{
            return null;
        }

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
    public List<TurnoDTO> listarTodos(){
        return (List) repository.findAll();
    }


}
