package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonManagedReference 
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonManagedReference 
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    @JsonManagedReference 
    private Servicio servicio;

    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private String color;

    private boolean reservado = false;
}
