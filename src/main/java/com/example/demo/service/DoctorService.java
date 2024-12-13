package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    
    // Obtener todas los pacientes
    public List<Doctor> obtenerDoctores() {
        return doctorRepository.findAll();
    }

    public Doctor crearDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}