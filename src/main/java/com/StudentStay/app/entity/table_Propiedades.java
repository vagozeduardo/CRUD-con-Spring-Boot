package com.StudentStay.app.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "propiedades")
public class table_Propiedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Propiedad;


    private String ID_Usuario;

    private String Direccion;
    private String Barrio_Colonia;
    private Double Precio;
    private String Estatus;


    public Long getID_Propiedad() {
        return ID_Propiedad;
    }

    public void setID_Propiedad(Long iD_Propiedad) {
        ID_Propiedad = iD_Propiedad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getBarrio_Colonia() {
        return Barrio_Colonia;
    }

    public void setBarrio_Colonia(String barrio_Colonia) {
        Barrio_Colonia = barrio_Colonia;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String iD_Usuario) {
        ID_Usuario = iD_Usuario;
    }

}
