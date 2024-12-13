package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.model.HistoriaClinica;
import com.example.demo.model.Paciente;
import com.example.demo.model.Turno;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.HistoriaClinicaService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TurnoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emr")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private HistoriaClinicaService historiaService;

    @GetMapping("/doctor/agenda")
    public String mostrarAgenda(Model model) {
        // Puedes pasar información adicional al modelo si es necesario
        return "calendario";  // Nombre de la plantilla HTML
    }

    @GetMapping("/doctor/listado-pacientes")
    public String listadoPacientes() {
        return "listado_pacientes";
    }

    @GetMapping("/doctor/mostrar/pacientes/{id}")
    public String mostrarPacientePage(@PathVariable Long id, Model model){
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        List<Turno> turnos = turnoService.obtenerTurnosReservadosPorPaciente(id);
    
        HistoriaClinica historia = historiaService.obtenerHistoriaClinicaPorPacienteId(id);

        model.addAttribute("paciente", paciente);
        model.addAttribute("turnos", turnos);

        if(historia != null) {
            model.addAttribute("descripcion", historia.getDescripcion());
        } else {
            model.addAttribute("descripcion", "Paciente sin Historia Clínica.");
        }
        
        return "mostrar_paciente";
    }
    
    @GetMapping("/doctor/inicio")
    public String inicioDoctor(Model model) {
        List<Turno> turnos = turnoService.obtenerTodosLosTurnos();
        model.addAttribute("turnos", turnos);
        return "doctor";
    }

    // @GetMapping("/doctor/buscar-paciente")
    // public String buscarPaciente(Model model, @RequestParam(required = false) String nombre) {
    //     if (nombre != null) {
    //         model.addAttribute("pacientes", pacienteService.buscarPorNombre(nombre));
    //     }
    //     return "buscar_paciente";
    // }

    @GetMapping("/doctor/registrar-paciente")
    public String registrarPacienteFormulario() {
        return "registrar_paciente";
    }

    @PostMapping("/doctor/registrar-paciente")
    public String registrarPaciente(@RequestParam String nombre, @RequestParam int edad) {
        pacienteService.registrarPaciente(nombre, edad);
        return "redirect:/doctor/inicio";
    }

    @GetMapping("/doctor/gestionar-turnos")
    public String gestionarTurnos(Model model, @RequestParam(required = false) Long pacienteId) {
        if (pacienteId != null) {
            model.addAttribute("turnos", turnoService.obtenerTurnosReservadosPorPaciente(pacienteId));
        } else {
            model.addAttribute("turnos", turnoService.obtenerTurnosReservadosPorPaciente(pacienteId));
        }
        return "gestionar_turnos";
    }

    @GetMapping("/doctor/turnos")
    public String mostrarTurnosDelDoctor(Model model) {
        Long doctorId = 1L; // Usar ID del doctor actual
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        model.addAttribute("turnos", doctor.getTurnosDisponibles());
        return "doctor_turnos";
    }

    @GetMapping("/doctor/crear-turno")
    public String mostrarFormularioCrearTurno() {
        return "crear_turno";
    }

    // @PostMapping("/doctor/crear-turno")
    // public String crearTurno(@RequestParam String fechaHora, @RequestParam Long doctorId) {
    //     LocalDateTime fechaHoraTurno = LocalDateTime.parse(fechaHora); // Convertir a LocalDateTime
    //     turnoService.crearTurno(null)
    //     return "redirect:/doctor/gestionar-turnos";
    // }
}
