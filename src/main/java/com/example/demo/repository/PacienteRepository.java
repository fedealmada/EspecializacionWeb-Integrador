package com.example.demo.repository;

import com.example.demo.model.Paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Método para buscar pacientes por nombre (parcial y sin distinción de mayúsculas)
    List<Paciente> findByNombreContainingIgnoreCase(String nombre);
}