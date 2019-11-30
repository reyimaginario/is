package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.wrapper.ListaGenerosDAO;
import com.hexsoft.athos.entities.GeneroDAO;
import com.hexsoft.athos.repositories.IGeneroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private IGeneroRepo generoRepo;

    public List<GeneroDAO> obtenerTodosLosGeneros() {
        return generoRepo.findAll();
    }

    public void guardarGenero(GeneroDAO generoDAO) {
        generoRepo.save(generoDAO);
    }

    public void guardarListaGeneros(ListaGenerosDAO listaGenerosDAO) {
        for (GeneroDAO generoDAO : listaGenerosDAO.getListaGenerosDAO()) {
            guardarGenero(generoDAO);
        }
    }
}
