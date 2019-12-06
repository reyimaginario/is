package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.LocalidadDAO;
import com.hexsoft.athos.entities.OcupacionDAO;
import com.hexsoft.athos.repositories.ILocalidadRepo;
import com.hexsoft.athos.repositories.IOcupacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcupacionService {

    @Autowired
    private IOcupacionRepo ocupacionRepo;

    public List<OcupacionDAO> obtenerTodasLasOcupaciones() {
        return ocupacionRepo.findAll();
    }

    public void guardarOcupacion(OcupacionDAO ocupacionDAO) {
        ocupacionRepo.save(ocupacionDAO);
    }

}
