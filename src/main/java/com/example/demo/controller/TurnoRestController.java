package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Turno;
import com.example.demo.model.TurnoDTO;
import com.example.demo.service.TurnoService;

@RestController
@RequestMapping("/api/turnos")
public class TurnoRestController {
    
    @Autowired
    private TurnoService turnoService;

    @GetMapping("")
    public List<Turno> obtenerTurnos() {
        return turnoService.obtenerTodosLosTurnos();
    }

    @PostMapping("")
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        // usamos @RequestBody para deserializar el JSON enviado al DTO
        Turno turno = turnoService.crearTurno(turnoDTO);
        return new ResponseEntity<>(turno, HttpStatus.CREATED);
    }

    @GetMapping("/paciente/{id}")
    public List<Turno> obtenerTurnosDePaciente(@RequestParam Long id) {
        return turnoService.obtenerTurnosReservadosPorPaciente(id);
    }

    // Métodos para editar y eliminar turnos
    // @GetMapping("/editar/{id}")
    // public String editarTurno(@PathVariable("id") Long id, Model model) {
    //     Optional<Turno> turno = turnoService.obtenerTurnoPorId(id);
    //     model.addAttribute("turno", turno);
    //     return "editar_turnos";  // Vista para editar paciente
    // }

    @GetMapping("/eliminar/{id}")
    public void eliminarTurno(@PathVariable("id") Long id) {
        turnoService.borrarTurnoPorId(id);
    }
}
