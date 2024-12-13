package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean isUsernameTaken(String username) {
        return usuarioRepository.findByUsername(username).isPresent();
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
