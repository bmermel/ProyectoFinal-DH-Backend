package com.digitalhouse.proyectoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ODONTOLOGOS")
public class Odontologo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="MATRICULA")
    private String matricula;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO")
    private String apellido;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private List<Turno> turno;

    public static Odontologo generarOdontologoAleatorio() {
        Random random = new Random();
        Odontologo odontologo = new Odontologo();
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
        String matricula = String.valueOf(random.nextInt(99999));
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setMatricula(matricula);
        return odontologo;
    }
}
