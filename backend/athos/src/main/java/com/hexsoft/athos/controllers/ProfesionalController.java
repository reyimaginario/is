package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.ProfesionalDTO;
import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.exceptions.NoExisteElProfesionalException;
import com.hexsoft.athos.services.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/*    @GetMapping(value = "/{dni}")
    public ProfesionalDTO obtenerProfesional(@PathVariable(value = "dni") String dni) {
        return profesionalService.obtenerProfesional(dni);
    }*/

    @GetMapping(value = "/{dni}")
    public ResponseEntity<ProfesionalDTO> obtenerProfesional(@PathVariable(value = "dni") String dni) {
        ProfesionalDTO profesionalDTO = null;

        try {
            profesionalDTO = profesionalService.obtenerProfesional(dni);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(profesionalDTO);
        }
        catch (NoExisteElProfesionalException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping
    public ProfesionalDTO guardarProfesional(@RequestBody ProfesionalDTO profesionalDTO) {
        return profesionalService.guardarProfesional(profesionalDTO);
    }

/*    @GetMapping(value = "/{dni}/obtenerSujetos")
    public List<SujetoDTO> listarSujetosPorProfesional(@PathVariable(value = "dni") String dni) {
        return profesionalService.listarSujetosPorProfesional(dni);
    }*/

    @GetMapping(value = "/{dni}/obtenerSujetos")
    public ResponseEntity<List<SujetoDTO>> listarSujetosPorProfesional(@PathVariable(value = "dni") String dni) {
        List<SujetoDTO> listaSujetosDTO = null;

        try {
            listaSujetosDTO = profesionalService.listarSujetosPorProfesional(dni);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(listaSujetosDTO);
        }
        catch (NoExisteElProfesionalException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
