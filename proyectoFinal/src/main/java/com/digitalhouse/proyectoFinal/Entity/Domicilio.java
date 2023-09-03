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
    @SequenceGenerator(name = "secuencia_domicilios", sequenceName = "secuencia_domicilios")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_domicilios")
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
