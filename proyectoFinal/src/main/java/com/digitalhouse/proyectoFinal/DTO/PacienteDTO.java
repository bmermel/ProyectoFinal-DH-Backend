package com.digitalhouse.proyectoFinal.DTO;

//import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
    private DomicilioDTO domicilio;

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
