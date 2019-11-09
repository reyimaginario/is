package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.services.SujetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:8080")   //TODO  borrar
@RestController
@RequestMapping(value = "/sujeto")
public class SujetoController {

    @Autowired
    private SujetoService sujetoService;
    

    @GetMapping
    public List<SujetoDTO> obenerTodosLosSujetos() {
        return sujetoService.obenerTodosLosSujetos();
    }

    @GetMapping(value = "/{dni}")
    public SujetoDTO obtenerSujeto(@PathVariable(value = "dni") String dni) {
        return sujetoService.obtenerSujeto(dni);
    }


    @PostMapping
    public SujetoDTO guardarSujeto(@RequestBody SujetoDTO sujetoDTO) {
        return sujetoService.guardarSujeto(sujetoDTO);
    }



}
