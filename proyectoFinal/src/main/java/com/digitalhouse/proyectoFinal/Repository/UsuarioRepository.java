package com.digitalhouse.proyectoFinal.Repository;

import com.digitalhouse.proyectoFinal.Entity.Odontologo;
import com.digitalhouse.proyectoFinal.Entity.Turno;
import com.digitalhouse.proyectoFinal.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Optional<Usuario> findByEmail(String email);


}
