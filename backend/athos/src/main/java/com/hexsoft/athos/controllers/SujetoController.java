package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.exceptions.NoExisteElSujetoException;
import com.hexsoft.athos.services.SujetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<SujetoDTO> obtenerSujeto(@PathVariable(value = "dni") String dni) {
        SujetoDTO sujetoDTO = null;
        try {
            sujetoDTO = sujetoService.obtenerSujeto(dni);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(sujetoDTO);
        }
        catch (NoExisteElSujetoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Mensaje", e.getMessage())
                    .body(null);
        }
    }


    @PostMapping
    public SujetoDTO guardarSujeto(@RequestBody SujetoDTO sujetoDTO) {
        return sujetoService.guardarSujeto(sujetoDTO);
    }


    @GetMapping(value = "/{dni}/obtenerEvaluaciones")
    public ResponseEntity<List<EvaluacionPsicologicaDTO>> listarEvaluacionesPorSujeto(@PathVariable(value = "dni") String dni) {
        List<EvaluacionPsicologicaDTO> listaEvaluacionesDTO = null;
        try {
            listaEvaluacionesDTO = sujetoService.listarEvaluacionesPorSujeto(dni);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(listaEvaluacionesDTO);
        }
        catch (NoExisteElSujetoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Mensaje", e.getMessage())
                    .body(null);
        }
    }



}
