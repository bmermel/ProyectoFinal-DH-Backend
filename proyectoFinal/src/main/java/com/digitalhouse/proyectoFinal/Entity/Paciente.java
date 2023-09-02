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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="DNI")
    private String dni;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="DOMICILIO")
    @ManyToOne
    @JoinColumn(name="Domicilio_id")
    private String domicilio;
    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @OneToMany(mappedBy = "PACIENTES")
    @JoinColumn(name = "PACIENTES_id")
    private List<Turno> turnos;
}
