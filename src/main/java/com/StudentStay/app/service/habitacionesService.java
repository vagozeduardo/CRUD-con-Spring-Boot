package com.StudentStay.app.service;

import java.util.List;
import com.StudentStay.app.entity.HabitacionesDTO;
import com.StudentStay.app.entity.MenuHabitacionesDTO;
import com.StudentStay.app.entity.table_habitaciones;

public interface habitacionesService {

    List<table_habitaciones> findAllHabitaciones();

    // Optional<table_usuario> findByNombreuserAndPassworduser(String Nombre, String
    // Contrasena);
    // HabitacionesDTO findByIdHabitacionDates(Long idHabitacion);
    HabitacionesDTO findByIdHabitacionDates(Integer ID_Habitacion);

    List<MenuHabitacionesDTO> obtenerPrimerasseisHabitaciones();

}
