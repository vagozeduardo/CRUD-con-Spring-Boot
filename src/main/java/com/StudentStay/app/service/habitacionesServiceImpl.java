package com.StudentStay.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentStay.app.Repository.studentHabitacionesRepository;
import com.StudentStay.app.entity.HabitacionesDTO;
import com.StudentStay.app.entity.MenuHabitacionesDTO;
import com.StudentStay.app.entity.table_habitaciones;

@Service
public class habitacionesServiceImpl implements habitacionesService {

    @Autowired
    studentHabitacionesRepository studenthabitacionesrepository;

    @Override
    public List<table_habitaciones> findAllHabitaciones() {
        return studenthabitacionesrepository.findAll();
    }

    @Override
    public HabitacionesDTO findByIdHabitacionDates(Integer ID_Habitacion) {
        return studenthabitacionesrepository.findByIdHabitacionDates(ID_Habitacion);
    }


    @Override
    public List<MenuHabitacionesDTO> obtenerPrimerasseisHabitaciones(){
        return studenthabitacionesrepository.obtenerPrimerasseisHabitaciones();
    }
}
