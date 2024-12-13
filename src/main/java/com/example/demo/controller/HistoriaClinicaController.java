package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.HistoriaClinica;
import com.example.demo.service.HistoriaClinicaService;

@Controller
@RequestMapping("/emr/doctor")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    // Vista para ver la historia clínica
    @GetMapping("/historia-clinica/{pacienteId}")
    public String verHistoriaClinica(@PathVariable("pacienteId") Long pacienteId, Model model) {
        HistoriaClinica historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorPacienteId(pacienteId);
        model.addAttribute("historiaClinica", historiaClinica);
        return "ver_historia_clinica";
    }

    // Vista para editar la historia clínica
    @GetMapping("/editar-historia-clinica/{pacienteId}")
    public String editarHistoriaClinica(@PathVariable("pacienteId") Long pacienteId, Model model) {
        HistoriaClinica historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorPacienteId(pacienteId);
        if(historiaClinica == null) {
            HistoriaClinica historiaClinica2 = new HistoriaClinica();
            model.addAttribute("historiaClinica", historiaClinica2);
        } else {
            model.addAttribute("historiaClinica", historiaClinica);
        }
        
        return "editar_historia_clinica";
    }

    // Acción para guardar los cambios de la historia clínica
    @PostMapping("/guardar-historia-clinica")
    public String guardarHistoriaClinica(@ModelAttribute HistoriaClinica historiaClinica) {
        historiaClinicaService.guardarHistoriaClinica(historiaClinica);
        return "redirect:/historia-clinica/" + historiaClinica.getPaciente().getId();
    }
}
