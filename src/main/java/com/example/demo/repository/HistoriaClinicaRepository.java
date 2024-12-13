package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HistoriaClinica;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    HistoriaClinica findByPacienteId(Long id);
}
