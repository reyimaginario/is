package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.ProfesionalDTO;
import com.hexsoft.athos.entities.EstudioDAO;
import com.hexsoft.athos.entities.GeneroDAO;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.services.EstudioService;
import com.hexsoft.athos.services.GeneroService;
import com.hexsoft.athos.services.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/iniciar")
public class InicializadorController {

    @Autowired
    private ProfesionalService profesionalService;
    @Autowired
    private GeneroService generoService;
    @Autowired
    private EstudioService estudioService;

    @GetMapping
    public void inicializar() {

        cargarGeneros();
        cargarEstudios();
        cargarProfesionales();

    }



    private void cargarGeneros() {
        GeneroDAO generoDAO;

        generoDAO = new GeneroDAO("Femenino");
        generoService.guardarGenero(generoDAO);
        generoDAO = new GeneroDAO("Masculino");
        generoService.guardarGenero(generoDAO);
        generoDAO = new GeneroDAO("Otro");
        generoService.guardarGenero(generoDAO);

    }

    private void cargarEstudios() {
        EstudioDAO estudioDAO;

        estudioDAO = new EstudioDAO("Primario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Secundario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Terciario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Universitario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Postgrado");
        estudioService.guardarEstudio(estudioDAO);

    }

    private void cargarProfesionales() {
        ProfesionalDTO profesionalDTO = null;

        profesionalDTO = new ProfesionalDTO("11222333", "Sigmund", "Freud", "1", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);
        profesionalDTO = new ProfesionalDTO("22333444", "Jacques", "Lacan", "2", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);
        profesionalDTO = new ProfesionalDTO("33444555", "Carl",    "Jung",  "3", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);

    }
    /*
    *

insert into sujeto (dni, nombre, apellido, profesional_dni) values ('1', 'Teddy',  'Daniels',    22333444);
insert into sujeto (dni, nombre, apellido, profesional_dni) values ('2', 'Sabina', 'Spielrein',  33444555);
insert into sujeto (dni, nombre, apellido, profesional_dni) values ('3', 'Eliza',  'Beckinsale', 22333444);
    * */
}
