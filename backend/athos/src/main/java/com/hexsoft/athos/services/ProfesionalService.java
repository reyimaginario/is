package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.repositories.IProfesionalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalService {

    @Autowired
    private IProfesionalRepo profesionalRepo;

    public List<ProfesionalDAO> getAllProfesional() {
        return profesionalRepo.findAll();
    }

    public ProfesionalDAO saveProfesional(ProfesionalDAO profesional) {
        return profesionalRepo.save(profesional);
    }

    public ProfesionalDAO getProfesional(String dni) {

        ProfesionalDAO profesionalDAO = null;

        Optional<ProfesionalDAO> profesionalOtional = profesionalRepo.findById(dni);

        if (profesionalOtional.isPresent()) {
            profesionalDAO = profesionalOtional.get();
        }

        return profesionalDAO;
    }

}
