package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class TurnoDTO {
    private Long doctorId;
    private Long pacienteId;
    private Long servicioId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private String color;
    private boolean reservado = false;    
}
