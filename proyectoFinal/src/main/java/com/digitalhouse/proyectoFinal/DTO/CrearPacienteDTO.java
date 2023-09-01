package com.digitalhouse.proyectoFinal.DTO;

public record CrearPacienteDto(String nombre,
                               String apellido,
                               String dni,
                               CrearDomicilioDto domicilio) {

    public CrearPacienteDto(String nombre, String apellido, String dni) {
        this(nombre,apellido,dni,null);
    }
}