package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.Sujeto;
import com.hexsoft.athos.repositories.ISujetoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SujetoService {

    @Autowired
    private ISujetoRepo sujetoRepo;


    public List<Sujeto> obtenerSujetosPorProfesional(String profesionalDNI) {
        return sujetoRepo.findByDni(profesionalDNI);
    }

}
