package com.digitalhouse.proyectoFinal.DTO;

public record CrearPacienteDTO(String nombre,
                               String apellido,
                               String dni,
                               CrearDomicilioDTO domicilio) {

    public CrearPacienteDTO(String nombre, String apellido, String dni) {
        this(nombre,apellido,dni,null);
    }
}