package com.digitalhouse.proyectoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "ODONTOLOGOS_id")
    @JsonIgnore
    private Odontologo odontologo;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "PACIENTES_id")
    @JsonIgnore
    private Paciente paciente;
}
