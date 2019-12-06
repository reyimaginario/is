package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.FiltroBaremoDTO;
import com.hexsoft.athos.entities.BaremoDAO;
import com.hexsoft.athos.services.BaremoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "baremo")
public class BaremoController {

    @Autowired
    private BaremoService baremoService;

    @GetMapping
    public List<BaremoDAO> obtenerTodosLosBaremo() {
        return baremoService.obtenerTodosLosBaremo();
    }


    @GetMapping(value = "/filtrar")
    public List<BaremoDAO> obtenerBaremosFiltrados(@RequestBody FiltroBaremoDTO filtro) {
        return baremoService.obtenerBaremosFiltrados(filtro);
    }

}
