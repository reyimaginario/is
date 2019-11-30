package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.wrapper.ListaEstudiosDAO;
import com.hexsoft.athos.entities.EstudioDAO;
import com.hexsoft.athos.services.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estudio")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @GetMapping
    public List<EstudioDAO> obtenerTodosLosEstudios() {
        return estudioService.obtenerTodosLosEstudios();
    }

    @PostMapping
    public void guardarEstudio(@RequestBody EstudioDAO estudioDAO) {
        estudioService.guardarEstudio(estudioDAO);
    }

    @PostMapping(value = "/todos")
    public void guardarListaEstudios(@RequestBody ListaEstudiosDAO listaEstudiosDAO) {
        estudioService.guardarListaEstudios(listaEstudiosDAO);
    }
}
