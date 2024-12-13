package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.isUsernameTaken(usuario.getUsername())) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso.");
        }

        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}
