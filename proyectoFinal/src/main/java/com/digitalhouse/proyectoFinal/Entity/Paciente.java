package com.digitalhouse.proyectoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Domicilio_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Domicilio domicilio;
    @Column(name="FECHAALTA")
    private Date fechaAlta;
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Turno> turnos;

    public static Paciente generarPacienteAleatorio() {
        Random random = new Random();
        Paciente paciente = new Paciente();
        String[] nombres = {"Aarón", "Adrián", "Álvaro", "Alejandro", "Ángel", "Antonio", "Benjamín",
                            "Bernardo", "Bernabé", "Blas", "Bruno", "César", "Daniel", "David", "Diego",
                            "Enrique", "Ernesto", "Esteban", "Federico", "Fernando", "Francisco",
                            "Francisco Javier", "Gabriel", "Gonzalo", "Guillermo", "Ignacio", "Inés",
                            "Isabel", "Javier", "Jorge", "Juan", "Juan José", "Julia", "Laura", "Luis",
                            "Irina", "Lucía", "Manuel", "María", "María Carmen", "María Isabel", "María José",
                            "Marta", "Martín", "Miguel", "Mónica", "Nuria", "Óscar", "Pablo", "Pedro", "Rafael",
                            "Raúl", "Ricardo", "Roberto", "Rocío", "Rodrigo", "Rosalía", "Rosa", "Sandra",
                            "Sara", "Santiago", "Sergio", "Susana", "Teresa", "Tomás", "Valeria", "Victoria",
                            "Virginia", "Vicente", "Ximena", "Yaiza", "Yago", "Yaiza", "Yolanda",};

        String[] apellidos = {"Pérez", "González", "Rodríguez", "Sánchez", "López", "Martínez", "Fernández",
                              "García", "Gómez", "Díaz", "Hernández","Alonso", "Álvarez", "Ángel", "Arias",
                              "Benítez", "Blanco", "Cárdenas", "Carmona", "Castillo", "Castro", "Córdoba",
                              "Cortés", "Díaz", "Domínguez", "Escobar", "Fernández", "Flores", "García",
                              "González", "Gutiérrez", "Hernández", "Jiménez", "López", "Martínez", "Méndez",
                              "Molina", "Montero", "Muñoz", "Navarro", "Olivares", "Ortiz", "Pérez", "Peña",
                              "Ramírez", "Rodríguez", "Ruiz", "Sánchez", "Serrano", "Suárez", "Torres", "Valdés",
                              "Vargas", "Vázquez", "Villalobos"};

        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido = apellidos[random.nextInt(apellidos.length)];
        String dni = String.valueOf(random.nextInt(999999999));
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(dni);
        return paciente;
    }

}
