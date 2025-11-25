package com.StudentStay.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.StudentStay.app.entity.HabitacionesDTO;
import com.StudentStay.app.entity.MenuHabitacionesDTO;
import com.StudentStay.app.entity.table_habitaciones;
import com.StudentStay.app.service.habitacionesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class habitacionesController {

    @Autowired
    habitacionesService habitacionesServicios;

    @GetMapping("/habitacionesRegistradas")
    public List<table_habitaciones> findallhabitaciones() {
        return habitacionesServicios.findAllHabitaciones();
    };

    @GetMapping("/subConsulta/{ID_Habitacion}")
    public ResponseEntity<HabitacionesDTO> getHabitacionPorId(@PathVariable Integer ID_Habitacion) {
        HabitacionesDTO infohabitacion = habitacionesServicios.findByIdHabitacionDates(ID_Habitacion);
        return ResponseEntity.ok(infohabitacion);
    }

    // intente hacer una consulta a la tabla de usuarios y estoy en el controller de habitaviones jajajja
    /*@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioService.findByEmail(loginRequest.getEmail());
        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            if (usuario.getTipoUsuario().equals("usuario1")) {
                return ResponseEntity.ok("redirect:/usuario1.html");
            } else if (usuario.getTipoUsuario().equals("usuario2")) {
                return ResponseEntity.ok("redirect:/usuario2.html");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }*/


    @GetMapping("/habitacionesonlyseis")
    public ResponseEntity<List<MenuHabitacionesDTO>> obtenerPrimerasSeisHabitaciones() {
        List<MenuHabitacionesDTO> habitaciones = habitacionesServicios.obtenerPrimerasseisHabitaciones();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

}
