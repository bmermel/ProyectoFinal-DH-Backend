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

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToMany(mappedBy = "Domicilio")

    private Integer id;
    @Column(name="CALLE")

    private String calle;
    @Column(name="NUMERO")

    private String numero;
    @Column(name="LOCALIDAD")


    private String localidad;
    @Column(name="PROVINCIA")

    private String provincia;
}
