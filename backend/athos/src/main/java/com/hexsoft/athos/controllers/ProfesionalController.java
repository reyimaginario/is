package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.ProfesionalDTO;
import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.services.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profesional")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;


    @GetMapping
    public List<ProfesionalDTO> obtenerTodosLosProfesionales() {
        return profesionalService.obtenerTodosLosProfesionales();
    }

    @GetMapping(value = "/{dni}")
    public ProfesionalDTO obtenerProfesional(@PathVariable(value = "dni") String dni) {
        return profesionalService.obtenerProfesional(dni);
    }

    @PostMapping
    public ProfesionalDTO guardarProfesional(@RequestBody ProfesionalDTO profesionalDTO) {
        return profesionalService.guardarProfesional(profesionalDTO);
    }

    @GetMapping(value = "/{dni}/obtenerSujetos")
    public List<SujetoDTO> listarSujetosPorProfesional(@PathVariable(value = "dni") String dni) {
        return profesionalService.listarSujetosPorProfesional(dni);
    }



}
