package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HistoriaClinica;
import com.example.demo.repository.HistoriaClinicaRepository;

@Service
public class HistoriaClinicaService {
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinica obtenerHistoriaClinicaPorPacienteId(Long pacienteId) {
        return historiaClinicaRepository.findByPacienteId(pacienteId);
    }

    public void guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        historiaClinicaRepository.save(historiaClinica);
    }
}
