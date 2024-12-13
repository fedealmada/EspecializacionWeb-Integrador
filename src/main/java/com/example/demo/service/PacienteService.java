package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
  
    // Método para registrar un nuevo paciente
    public Paciente registrarPaciente(String nombre, int edad) {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        return pacienteRepository.save(paciente);
    }

    // // Método para buscar pacientes por nombre
    // public List<Paciente> buscarPorNombre(String nombre) {
    //     return pacienteRepository.findByNombreContainingIgnoreCase(nombre);
    // }

    // Método para buscar paciente por nombre de usuario
    public Paciente obtenerPacientePorUsuario(String username) {
        List<Paciente> pacientes = pacienteRepository.findAll();

        for(Paciente paciente : pacientes) {
            if(paciente.getUsername().equals(username)) {
                return paciente;
            }
        }
        return null;

    }

    // Método para obtener un paciente por su ID
    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado con ID: " + id));
    }

    // Método para obtener todos los pacientes
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    // Eliminar una paciente por su ID
    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }
}
