package com.StudentStay.app.entity;

import java.math.BigDecimal;

public class HabitacionesDTO { // DTO (Data Transfer Object) xq pido solo datos en especificos y no uysare los entity

    private Integer ID_Habitacion;
    private String titulo;
    private String Anfitrion;
    private String Descripcion;
    private String Ubicación;
    private BigDecimal Precio;

    
    public HabitacionesDTO(Integer ID_Habitacion,String titulo, String Anfitrion,String Descripcion, String Ubicación, BigDecimal Precio) {
        this.ID_Habitacion = ID_Habitacion;
        this.titulo = titulo;
        this.Anfitrion = Anfitrion;
        this.Descripcion = Descripcion;
        this.Ubicación = Ubicación;
        this.Precio = Precio;
    }

    public Integer getID_Habitacion() {
        return ID_Habitacion;
    }

    public void setID_Habitacion(Integer iD_Habitacion) {
        ID_Habitacion = iD_Habitacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnfitrion() {
        return Anfitrion;
    }

    public void setAnfitrion(String Anfitrion) {
        this.Anfitrion = Anfitrion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUbicación() {
        return Ubicación;
    }

    public void setUbicación(String Ubicación) {
        this.Ubicación = Ubicación;
    }

    public BigDecimal getPrecio() {
        return Precio;
    }

    public void setPrecio(BigDecimal Precio) {
        this.Precio = Precio;
    }

}
