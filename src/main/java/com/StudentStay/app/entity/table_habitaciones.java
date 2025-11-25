package com.StudentStay.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class table_habitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Habitacion;

    private Long ID_Propiedad;

    private String Tamano;

    
    private String Amueblada;

    private double Precio;

    private String Descripcion;

    private String Sobrenombre;



    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String getSobrenombre() {
        return Sobrenombre;
    }
    public void setSobrenombre(String Sobrenombre) {
        this.Sobrenombre = Sobrenombre;
    }
    public Long getID_Propiedad() {
        return ID_Propiedad;
    }
    public void setID_Propiedad(Long ID_Propiedad) {
        this.ID_Propiedad = ID_Propiedad;
    }
    
    public String getTamano() {
        return Tamano;
    }
    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }
    public String getAmueblada() {
        return Amueblada;
    }
    public void setAmueblada(String Amueblada) {
        this.Amueblada = Amueblada;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    public Integer getID_Habitacion() {
        return ID_Habitacion;
    }
    public void setID_Habitacion(Integer ID_Habitacion) {
        this.ID_Habitacion = ID_Habitacion;
    }

    

}
