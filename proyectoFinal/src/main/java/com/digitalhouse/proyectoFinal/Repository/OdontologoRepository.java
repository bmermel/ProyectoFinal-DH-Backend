package com.digitalhouse.proyectoFinal.Repository;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
//    @Query("SELECT o FROM Odontologos o WHERE o.matricula = :?1")
//    Odontologo findByMatricula(String matricula);
}
