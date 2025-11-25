package com.StudentStay.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentStay.app.entity.table_usuario;
import java.util.Optional;

public interface usuariosRepository extends JpaRepository<table_usuario, Long> {

    // @Query("SELECT tu FROM table_usuario tu WHERE tu.Correo = :Correo")
    // Optional<table_usuario> findByCorreo(String Correo);
    @Query("SELECT tu FROM table_usuario tu WHERE tu.Correo = :Correo")
    Optional<table_usuario> findByCorreo(String Correo);
}
