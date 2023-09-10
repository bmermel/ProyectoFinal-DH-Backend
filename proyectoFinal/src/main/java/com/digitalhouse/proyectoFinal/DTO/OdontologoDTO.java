package com.digitalhouse.proyectoFinal.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdontologoDTO {
    private Integer id;
    private String matricula;
    private String nombre;
    private String apellido;
    private List<TurnoDTO> turno;
}