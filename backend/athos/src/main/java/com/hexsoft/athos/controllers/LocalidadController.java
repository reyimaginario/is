package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.wrapper.ListaGenerosDAO;
import com.hexsoft.athos.entities.GeneroDAO;
import com.hexsoft.athos.entities.LocalidadDAO;
import com.hexsoft.athos.services.GeneroService;
import com.hexsoft.athos.services.LocalodadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/localidad")
public class LocalidadController {

    @Autowired
    private LocalodadService localodadService;

    @GetMapping
    public List<LocalidadDAO> obtenerTodasLasLocalidades() {
        return localodadService.obtenerTodasLasLocalidades();
    }

    @PostMapping
    public void guardarLocalidad(@RequestBody LocalidadDAO localidadDAO) {
        localodadService.guardarLocalidad(localidadDAO);
    }


}
