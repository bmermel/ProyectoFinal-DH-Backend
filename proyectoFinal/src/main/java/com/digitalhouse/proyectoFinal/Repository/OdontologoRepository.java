package com.digitalhouse.proyectoFinal.Repository;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OdontologoRepository extends JpaRepository<Odontologo,int> {
}
