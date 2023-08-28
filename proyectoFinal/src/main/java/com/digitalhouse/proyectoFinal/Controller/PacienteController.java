package com.digitalhouse.proyectoFinal.Controller;

import com.digitalhouse.proyectoFinal.Services.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final Logger LOGGER = Logger.getLogger(PacienteController.class);
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }



}
