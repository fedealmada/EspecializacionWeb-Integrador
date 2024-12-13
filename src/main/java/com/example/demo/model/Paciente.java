package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario {

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private HistoriaClinica historiaClinica;
}
