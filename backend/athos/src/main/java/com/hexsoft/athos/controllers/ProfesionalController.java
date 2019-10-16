package com.hexsoft.athos.controllers;

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
    public List<ProfesionalDAO> getAllProfesional() {
        return profesionalService.getAllProfesional();
    }

    @GetMapping(value = "/{dni}")
    public ProfesionalDAO getProfesional(@PathVariable(value = "dni") String dni) {
        return profesionalService.getProfesional(dni);
    }


    @PostMapping
    public ProfesionalDAO saveProfesional(@RequestBody ProfesionalDAO profesional) {
        return profesionalService.saveProfesional(profesional);
    }



}