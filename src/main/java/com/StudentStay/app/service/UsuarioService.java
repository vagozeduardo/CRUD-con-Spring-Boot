package com.StudentStay.app.service;

import java.util.Optional;


import com.StudentStay.app.entity.table_usuario;

public interface UsuarioService {

    table_usuario GuardarUsuario(table_usuario usuario_datos);

    Optional<table_usuario> findByCorreo(String Correo);

    boolean login(String Correo, String Contrasena);

}
