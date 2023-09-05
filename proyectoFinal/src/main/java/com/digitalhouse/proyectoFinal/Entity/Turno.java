package com.digitalhouse.proyectoFinal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turno {
    @Id
    //@SequenceGenerator(name = "secuencia_turnos", sequenceName = "secuencia_turnos")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_turnos")
    @GeneratedValue
    private int id;
    @Column(name="F")
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ODONTOLOGOS_id")
    private Odontologo odontologo;
    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "PACIENTES_id")
    private Paciente paciente;
}
