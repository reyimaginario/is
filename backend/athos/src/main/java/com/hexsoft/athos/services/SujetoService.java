package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.repositories.ISujetoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SujetoService {

    @Autowired
    private ISujetoRepo sujetoRepo;


    public List<SujetoDAO> getAllSujeto() {
        return sujetoRepo.findAll();
    }

    public SujetoDAO saveSujeto(SujetoDAO sujeto) {
        return sujetoRepo.save(sujeto);
    }

    public SujetoDAO getSujeto(String dni) {

        SujetoDAO sujetoDAO = null;

        Optional<SujetoDAO> sujetoOtional = sujetoRepo.findById(dni);

        if (sujetoOtional.isPresent()) {
            sujetoDAO = sujetoOtional.get();
        }

        return sujetoDAO;
    }

    


/*    public List<SujetoDAO> obtenerSujetosPorProfesional(String profesionalDNI) {
        return sujetoRepo.findByDni(profesionalDNI);
    }*/

}
