package com.digitalhouse.proyectoFinal.Repository;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PacienteRepository  extends JpaRepository<Paciente,Integer> {
}
