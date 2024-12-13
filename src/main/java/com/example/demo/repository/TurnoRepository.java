package com.example.demo.repository;

import com.example.demo.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByReservadoFalse();
    List<Turno> findByPacienteId(Long pacienteId);
}
