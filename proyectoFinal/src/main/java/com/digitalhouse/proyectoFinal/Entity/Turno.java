package com.digitalhouse.proyectoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
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
    @Column(name="FECHA")
    private LocalDate fecha;
    @Column(name="HORA")
    private LocalTime hora;
    @ManyToOne
    @JoinColumn(name = "ODONTOLOGOS_id")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "PACIENTES_id")
    private Paciente paciente;
}
