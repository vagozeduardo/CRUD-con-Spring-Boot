package com.StudentStay.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class principal {

    @GetMapping("/")
    public String home() {
        return "cuerpo"; // Busca el archivo cuerpo.html en `src/main/resources/templates/`
    }

}
