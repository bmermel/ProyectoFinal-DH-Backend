package com.digitalhouse.proyectoFinal.Repository;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
    Optional<Odontologo> findByMatricula(String matricula);

}
