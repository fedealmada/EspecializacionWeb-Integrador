package com.example.demo.controller;

import com.example.demo.model.Turno;
import com.example.demo.service.TurnoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    // Endpoint que muestra una vista de los turnos
    @GetMapping("/turnos")
    public String listarTurnosDisponibles(Model model) {
        List<Turno> turnos = turnoService.obtenerTurnosDisponibles();
        model.addAttribute("turnos", turnos);
        return "turnos";
    } 
}