package com.digitalhouse.proyectoFinal.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Domicilio {
    @Id
    //@SequenceGenerator(name = "secuencia_domicilios", sequenceName = "secuencia_domicilios")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_domicilios")
    @GeneratedValue
    //@OneToMany(mappedBy = "Domicilio")

    private Integer id;
    @Column(name="CALLE")

    private String calle;
    @Column(name="NUMERO")

    private String numero;
    @Column(name="LOCALIDAD")


    private String localidad;
    @Column(name="PROVINCIA")

    private String provincia;

    public static Domicilio generarDomicilioAleatorio() {
        Random random = new Random();
        Domicilio domicilio = new Domicilio();
        String[] calle = {"Avenida Independencia", "Avenida Entre Ríos", "Avenida Belgrano Sur", "Calle Defensa", "Avenida San Martín", "Avenida Rivadavia", "Calle Sáenz", "Calle Juan Bautista Alberdi", "Calle Boedo", "Avenida La Plata", "Avenida Directorio", "Avenida Monroe", "Calle Mendoza", "Avenida Triunvirato", "Calle Dorrego", "Calle Godoy Cruz", "Avenida Scalabrini Ortiz", "Calle Gurruchaga", "Calle Thames", "Calle Guatemala", "Calle Armenia", "Avenida Canning", "Avenida Elcano", "Avenida Congreso", "Calle Pedro Goyena", "Avenida Honorio Pueyrredón", "Calle José Bonifacio", "Calle José Hernández", "Avenida Sante Fe", "Avenida Libertador"};
        String num = String.valueOf(random.nextInt(9999));
        String[] provincia = {"Buenos Aires", "Córdoba", "Rosario", "Mendoza", "San Miguel de Tucumán", "La Plata", "Mar del Plata", "Salta", "Santa Fe", "San Juan", "Resistencia", "Corrientes", "Posadas", "Neuquén", "Formosa", "San Salvador de Jujuy", "Paraná", "Bahía Blanca", "Concordia", "La Rioja", "Santiago del Estero", "San Fernando del Valle de Catamarca", "Río Cuarto", "Comodoro Rivadavia", "Santa Rosa", "San Carlos de Bariloche", "Trelew", "Viedma", "Rawson"};
        //domicilio.setId();
        domicilio.setCalle(calle[random.nextInt(calle.length)]);
        domicilio.setNumero(String.valueOf(random.nextInt(9999)));
        String provi = provincia[random.nextInt(provincia.length)];
        domicilio.setProvincia(provi);
        domicilio.setLocalidad(provi);
        return domicilio;
    }
}
