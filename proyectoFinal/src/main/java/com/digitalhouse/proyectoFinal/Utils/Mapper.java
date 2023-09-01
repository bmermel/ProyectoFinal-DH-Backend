package com.digitalhouse.proyectoFinal.Utils;

import com.digitalhouse.proyectoFinal.DTO.CrearPacienteDTO;
import com.digitalhouse.proyectoFinal.DTO.PacienteDTO;
import com.digitalhouse.proyectoFinal.Entity.Domicilio;
import com.digitalhouse.proyectoFinal.Entity.Paciente;

public class Mapper {

    public static PacienteDTO map(CrearPacienteDTO dto) {
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();

        paciente.setApellido(dto.apellido());
        paciente.setDni(dto.dni());
        paciente.setNombre(dto.nombre());
        paciente.setDomicilio(String.valueOf(domicilio));

        domicilio.setCalle(dto.domicilio().getCalle());
        domicilio.setLocalidad(dto.domicilio().getLocalidad());
        domicilio.setNumero(dto.domicilio().getNumero());
        domicilio.setProvincia(dto.domicilio().getProvincia());

        return paciente;
    }

    public static Paciente map(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();

        paciente.setId(dto.getId());
        paciente.setFechaAlta(dto.getFechaAlta());
        paciente.setApellido(dto.getApellido());
        paciente.setDni(dto.getDni());
        paciente.setNombre(dto.getNombre());
        paciente.setDomicilio(String.valueOf(domicilio));

        domicilio.setId(dto.getDomicilio().getId());
        domicilio.setCalle(dto.getDomicilio().getCalle());
        domicilio.setLocalidad(dto.getDomicilio().getLocalidad());
        domicilio.setNumero(dto.getDomicilio().getNumero());
        domicilio.setProvincia(dto.getDomicilio().getProvincia());

        return paciente;

    }

}