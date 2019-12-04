package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.LocalidadDAO;
import com.hexsoft.athos.repositories.ILocalidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalodadService {

    @Autowired
    private ILocalidadRepo localidadRepo;

    public List<LocalidadDAO> obtenerTodasLasLocalidades() {
        return localidadRepo.findAll();
    }

    public void guardarLocalidad(LocalidadDAO localidadDAO) {
        localidadRepo.save(localidadDAO);
    }

}
