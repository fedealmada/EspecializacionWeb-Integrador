package com.example.demo.controller;

import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TurnoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PacienteController {

    private final Long pacienteActualId = 1L; // Simular un paciente autenticado

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/emr/paciente/inicio")
    public String inicioPaciente() {
        return "paciente";
    }

    // Ruta para mostrar la lista de pacientes
    @GetMapping("/paciente/listado")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "listado_pacientes"; // nombre de la vista (HTML)
    }

    @PostMapping("/paciente/reservar")
    public String reservarTurno(@RequestParam Long turnoId) {

        turnoService.reservarTurno(turnoId, pacienteActualId);
        return "redirect:/paciente/turnos";
    }

    @PostMapping("/paciente/cancelarReserva")
    public String cancelarTurno(@RequestParam Long turnoId) {

        turnoService.cancelarTurno(turnoId, pacienteActualId);
        return "redirect:/paciente/turnos";
    }

    @GetMapping("/paciente/turnos")
    public String mostrarTurnosDisponibles(Model model) {
        model.addAttribute("turnos", turnoService.obtenerTurnosDisponibles());
        model.addAttribute("turnosReservados", turnoService.obtenerTurnosReservadosPorPaciente(pacienteActualId));
        return "paciente_turnos";
    }

    // Método para mostrar turnos reservados por el paciente
    @GetMapping("/paciente/mis-turnos")
    public String verTurnosReservados(Model model) {
        Long pacienteId = pacienteActualId; // Aquí se usaría el ID del paciente autenticado
        model.addAttribute("turnosReservados", turnoService.obtenerTurnosReservadosPorPaciente(pacienteId));
        return "paciente_turnos_reservados";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {
        pacienteService.delete(id);
        return "redirect:/api/pacientes/listado";
    }

    // Métodos para editar y eliminar pacientes
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable("id") Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        model.addAttribute("paciente", paciente);
        return "editar_pacientes"; // Vista para editar paciente
    }
}
