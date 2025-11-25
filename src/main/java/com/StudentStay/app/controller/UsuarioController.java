package com.StudentStay.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentStay.app.entity.table_usuario;
import com.StudentStay.app.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioservice;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody table_usuario usuario_datos, BindingResult resultado_error) { // el requestbody es el que procesa u obtiene el Json
        // System.out.println("\nDatos recibidos: "+usuario_datos+ "\n");
        if (resultado_error.hasErrors()) { //si hay errores en las validaciones pasa aqui
            Map<String, String> errores = new HashMap<>();  //inicia la variable o la forma de obtener el emnsaije en la validadicon
            resultado_error.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));// usa la propiedad Binding que se inyecto arriba
            return ResponseEntity.badRequest().body(errores); //retorna el error obtenido
        }
        try {
            usuarioservice.GuardarUsuario(usuario_datos);
        } catch (DataIntegrityViolationException e) {  // DataIntegrityViolationException es el que encarga de optener el error si hay en la base
            // como la base tiene el unique en correo dara una exepcion y esto obtendra esa excepcion y mostrara el mensaje personalizado o mostrara el error de la consulta
            Map<String, String> errores = new HashMap<>();
            errores.put("Correo", "El correo ya está registrado. Por favor, utiliza otro.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        } catch (Exception e) {
            // si ocurre un error que no esta relacionado a las validaciones pasaria aqui
            Map<String, String> errores = new HashMap<>();
            errores.put("Error general", "Ocurrió un error inesperado. Intenta más tarde."); // se póner el valor o mensaje si hay error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errores);// envia el mensaje declarado
        }

        //usuarioservice.GuardarUsuario(usuario_datos);
        return ResponseEntity.ok("Usuario registrado exitosamente"); // si todo esta bien retorna para decir que la consulta fue un exito, 220 ok algo asi

    }

    @PostMapping("/login") // post para enviar los datos de forma discreta
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credenciales) { // lo mismo de arriba
        String Correo = credenciales.get("Correo");
        String Contrasena = credenciales.get("Contrasena");
        boolean loginExitoso = usuarioservice.login(Correo, Contrasena);
        Map<String, Object> respuesta = new HashMap<>();
        if (loginExitoso) {
            respuesta.put("loginExitoso", true);
        } else {
            respuesta.put("loginExitoso", false);
        }
        return ResponseEntity.ok(respuesta);
    }

}
