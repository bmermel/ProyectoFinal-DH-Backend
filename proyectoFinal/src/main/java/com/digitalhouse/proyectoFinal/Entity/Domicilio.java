package com.digitalhouse.proyectoFinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
