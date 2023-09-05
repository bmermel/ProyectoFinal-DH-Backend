package com.digitalhouse.proyectoFinal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class VistaController {
    @GetMapping
    public String login(){
        return "./login.html";
    }
}
