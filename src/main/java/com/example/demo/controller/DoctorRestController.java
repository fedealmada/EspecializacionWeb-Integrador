package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.model.Paciente;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@RestController
@RequestMapping("/api/doctores")
public class DoctorRestController {
    @Autowired
    PacienteService pacienteService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;


    @GetMapping("")
    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }

    @GetMapping("/mostrar/paciente/{id}")
    public Paciente mostrarPacientePage(@RequestParam Long id) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        return paciente;
    }
}
