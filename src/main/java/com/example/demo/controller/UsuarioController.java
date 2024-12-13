package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUsuario(@RequestBody Usuario Usuario) {
        if (UsuarioService.isUsernameTaken(Usuario.getUsername())) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso.");
        }

        UsuarioService.guardarUsuario(Usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}
