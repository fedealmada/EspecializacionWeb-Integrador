package com.example.demo.service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Paciente;
import com.example.demo.model.Servicio;
import com.example.demo.model.Turno;
import com.example.demo.model.TurnoDTO;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.ServicioRepository;
import com.example.demo.repository.TurnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;


    public List<Turno> obtenerTodosLosTurnos() {
        return turnoRepository.findAll();
    }
    public List<Turno> obtenerTurnosDisponibles() {
        return turnoRepository.findByReservadoFalse();
    }

    public void borrarTurnoPorId(Long id) {
        turnoRepository.deleteById(id);
    }

    public Turno reservarTurno(Long turnoId, Long pacienteId) {
        Turno turno = turnoRepository.findById(turnoId).orElseThrow();
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow();
        turno.setReservado(true);
        turno.setPaciente(paciente);
        return turnoRepository.save(turno);
    }

    public Turno cancelarTurno(Long turnoId, Long pacienteId) {
        Turno turno = turnoRepository.findById(turnoId).orElseThrow();
        turno.setReservado(false);
        turno.setPaciente(null);
        return turnoRepository.save(turno);
    }

    public List<Turno> obtenerTurnosReservadosPorPaciente(Long pacienteId) {
        List<Turno> turnos = turnoRepository.findAll();
        List<Turno> turnosReservados = new ArrayList<Turno>();

        for(Turno turno : turnos) {
            if(turno.getPaciente().getId() == pacienteId) {
                turnosReservados.add(turno);
            }
        }

        return turnosReservados;
    }
    // Método para crear un nuevo turno que recibe un TurnoDTO
    public Turno crearTurno(TurnoDTO turnoDTO) {

        Doctor doctor = new Doctor();
        doctor.setId(turnoDTO.getDoctorId());

        Optional<Servicio> servicio = servicioRepository.findById(turnoDTO.getServicioId());

        Turno turno = new Turno();
        turno.setStart(turnoDTO.getStart());
        turno.setEnd(turnoDTO.getStart().plusHours(servicio.get().getBloqueTiempo()));
        turno.setReservado(false);
        turno.setDoctor(doctor); 
        turno.setTitle(servicio.get().getNombre());
        turno.setServicio(servicio.get());
        turno.setColor("006699");

        if(turnoDTO.getPacienteId() != null) {
            Paciente paciente = new Paciente();
            paciente.setId(turnoDTO.getPacienteId());
            turno.setPaciente(paciente);
        }

        return turnoRepository.save(turno);
    }    
}
