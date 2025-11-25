package com.StudentStay.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.StudentStay.app.Repository.usuariosRepository;
import com.StudentStay.app.entity.table_usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private usuariosRepository usuariosrepository;

    @Override
    public Optional<table_usuario> findByCorreo(String Correo) {
        return usuariosrepository.findByCorreo(Correo);
    };

    @Override
    public boolean login(String Correo, String Contrasena) {
        Optional<table_usuario> usuario = findByCorreo(Correo);
        if (usuario.isPresent()) {
            return usuario.get().getContrasena().equals(Contrasena);
        }
        return false;
    }

    @Override
    public table_usuario GuardarUsuario(table_usuario usuario_datos) {
        return usuariosrepository.save(usuario_datos);
    }



}
