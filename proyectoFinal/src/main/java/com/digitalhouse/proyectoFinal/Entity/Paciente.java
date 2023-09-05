package com.digitalhouse.proyectoFinal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class Paciente {
    @Id
  //  @SequenceGenerator(name = "secuencia_pacientes", sequenceName = "secuencia_pacientes")
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue
    private Integer id;
    @Column(name="DNI")
    private String dni;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @OneToOne
    @JoinColumn(name="Domicilio_id")
    private Domicilio domicilio;
    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @OneToMany(mappedBy = "paciente")
   private List<Turno> turnos;
}
