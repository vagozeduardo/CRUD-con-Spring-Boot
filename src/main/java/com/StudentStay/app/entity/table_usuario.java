package com.StudentStay.app.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
public class table_usuario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long ID_Usuario;

    @NotBlank(message = "El nombre no debe estar vacío")
    @Pattern(regexp = "^[A-Za-záéíóúñ]{2,}([\\s][A-Za-záéíóúñ]{2,})?$", message = "El nombre solo puede contener letras y 2 nombres max.")
    @JsonProperty("Nombre")
    private String Nombre;

    @NotBlank(message = "El Apellido_Paterno no debe estar vacío")
    @Pattern(regexp = "^[A-Za-záéíóúñ]{2,}(([\\s][A-Za-záéíóúñ]{2,})+)?$", message = "El apellido solo puede contener letras")
    @JsonProperty("Apellido_Paterno")
    private String Apellido_Paterno;

    @NotBlank(message = "El Apellido_Materno no debe estar vacío")
    @Pattern(regexp = "^[A-Za-záéíóúñ]{2,}(([\\s][A-Za-záéíóúñ]{2,})+)?$", message = "El apellido solo puede contener letras")
    @JsonProperty("Apellido_Materno")
    private String Apellido_Materno;

    @NotBlank(message = "El Correo no debe estar vacío")
    @Email
    @JsonProperty("Correo")
    private String Correo;

    @NotBlank(message = "El Contrasena no debe estar vacío")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número")
    @JsonProperty("Contrasena")
    private String Contrasena;

    @JsonProperty("Tipo_Usuario")
    private String Tipo_Usuario;

    
    public Long getID_Usuario() {
        return ID_Usuario;
    }


    public void setID_Usuario(Long ID_Usuario) {
        this.ID_Usuario=ID_Usuario;
    }


    public String getNombre() {
        return Nombre;  
    }


    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }


    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }


    public String getApellido_Materno() {
        return Apellido_Materno;
    }


    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }


    public String getCorreo() {
        return Correo;
    }


    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }


    public String getContrasena() {
        return Contrasena;
    }


    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }


    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }


    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }
    
    
}
