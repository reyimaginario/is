package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.wrapper.ListaEstudiosDAO;
import com.hexsoft.athos.entities.EstudioDAO;
import com.hexsoft.athos.repositories.IEstudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private IEstudioRepo estudioRepo;

    public List<EstudioDAO> obtenerTodosLosEstudios() {
        return estudioRepo.findAll();
    }

    public void guardarEstudio(EstudioDAO estudioDAO) {
        estudioRepo.save(estudioDAO);
    }

    public void guardarListaEstudios(ListaEstudiosDAO listaEstudiosDAO) {
        for (EstudioDAO estudioDAO : listaEstudiosDAO.getListaEstudiosDAO()) {
            guardarEstudio(estudioDAO);
        }
    }
}
