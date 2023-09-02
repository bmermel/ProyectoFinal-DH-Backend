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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
