package com.hexsoft.athos.controllers;

import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.services.SujetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sujeto")
public class SujetoController {

    @Autowired
    private SujetoService sujetoService;
    

    @GetMapping
    public List<SujetoDAO> getAllSujeto() {
        return sujetoService.getAllSujeto();
    }

    @GetMapping(value = "/{dni}")
    public SujetoDAO getSujeto(@PathVariable(value = "dni") String dni) {
        return sujetoService.getSujeto(dni);
    }


    @PostMapping
    public SujetoDAO saveSujeto(@RequestBody SujetoDAO sujeto) {
        return sujetoService.saveSujeto(sujeto);
    }



}
