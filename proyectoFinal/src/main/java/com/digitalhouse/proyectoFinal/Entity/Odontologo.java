package com.digitalhouse.proyectoFinal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ODONTOLOGOS")
public class Odontologo {

    @Id
    @SequenceGenerator(name = "secuencia_odontologos", sequenceName = "secuencia_odontologos")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_odontologos")
    private Integer id;

    @Column(name="MATRICULA")
    private String matricula;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO")
    private String apellido;

    @OneToMany(mappedBy = "ODONTOLOGOS")
    @JoinColumn(name = "ODONTOLGOS_id")
    private Turno turno;

}
