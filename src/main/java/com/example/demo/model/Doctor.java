package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Doctor extends Usuario {
    
    private @Getter String especialidad;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private @Getter List<Turno> turnosDisponibles;
}