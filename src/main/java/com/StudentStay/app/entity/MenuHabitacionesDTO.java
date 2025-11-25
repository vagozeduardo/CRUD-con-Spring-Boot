package com.StudentStay.app.entity;

import java.math.BigDecimal;

public class MenuHabitacionesDTO {

    private Integer ID_Habitacion;
    private String Sobrenombre;
    private String Descripcion;
    private BigDecimal Precio;

    // Constructor con 4 parámetros (muy importante para Hibernate)
    public MenuHabitacionesDTO(Integer ID_Habitacion,String Sobrenombre,String Descripcion,BigDecimal Precio) {
        this.ID_Habitacion = ID_Habitacion;
        this.Sobrenombre = Sobrenombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }


    public void setID_Habitacion(Integer ID_Habitacion) {
        this.ID_Habitacion = ID_Habitacion;
    }

    public void setSobrenombre(String Sobrenombre) {
        this.Sobrenombre = Sobrenombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecio(BigDecimal Precio) {
        this.Precio = Precio;
    }

    public Integer getID_Habitacion() {
        return ID_Habitacion;
    }

    public String getSobrenombre() {
        return Sobrenombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public BigDecimal getPrecio() {
        return Precio;
    }





}
