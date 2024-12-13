package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteRestController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> listarPacientes(@RequestParam(required = false) String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            return pacienteRepository.findByNombreContainingIgnoreCase(nombre);
        }
        return pacienteRepository.findAll();
    }

    // @GetMapping("/buscar")
    // public List<Paciente> buscarPacientes(@RequestParam String firstname) {
    //     return pacienteRepository.findByNombreContainingIgnoreCase(firstname);
    // }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}