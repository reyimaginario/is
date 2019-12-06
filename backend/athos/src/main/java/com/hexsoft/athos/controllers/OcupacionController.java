package com.hexsoft.athos.controllers;

import com.hexsoft.athos.entities.LocalidadDAO;
import com.hexsoft.athos.entities.OcupacionDAO;
import com.hexsoft.athos.services.LocalodadService;
import com.hexsoft.athos.services.OcupacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ocupacion")
public class OcupacionController {

    @Autowired
    private OcupacionService ocupacionService;

    @GetMapping
    public List<OcupacionDAO> obtenerTodasLasLocalidades() {
        return ocupacionService.obtenerTodasLasOcupaciones();
    }

    @PostMapping
    public void guardarLocalidad(@RequestBody OcupacionDAO ocupacionDAO) {
        ocupacionService.guardarOcupacion(ocupacionDAO);
    }


}
