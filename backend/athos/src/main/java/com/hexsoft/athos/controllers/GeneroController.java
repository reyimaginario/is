package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.wrapper.ListaGenerosDAO;
import com.hexsoft.athos.entities.GeneroDAO;
import com.hexsoft.athos.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<GeneroDAO> obtenerTodosLosGeneros() {
        return generoService.obtenerTodosLosGeneros();
    }

    @PostMapping
    public void guardarGenero(@RequestBody GeneroDAO generoDAO) {
        generoService.guardarGenero(generoDAO);
    }

    @PostMapping(value = "/todos")
    public void guardarListaGeneros(@RequestBody ListaGenerosDAO listaGenerosDAO) {
        generoService.guardarListaGeneros(listaGenerosDAO);
    }

}
