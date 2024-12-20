package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Servicio;
import com.example.demo.repository.ServicioRepository;

@RestController
@RequestMapping("/api/servicios")
public class ServicioRestController {
    @Autowired
    ServicioRepository servicioRepository;
    
    @GetMapping("")
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }
}
