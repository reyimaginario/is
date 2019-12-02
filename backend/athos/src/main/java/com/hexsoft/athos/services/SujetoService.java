package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.exceptions.NoExisteElSujetoException;
import com.hexsoft.athos.repositories.ISujetoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SujetoService {

    @Autowired
    private ISujetoRepo sujetoRepo;


    public List<SujetoDTO> obenerTodosLosSujetos() {
        List<SujetoDAO> listaSujetosDAO = sujetoRepo.findAll();
        List<SujetoDTO> listaSujetosDTO = new ArrayList<>();
        for (SujetoDAO sujetoDAO : listaSujetosDAO) {
            SujetoDTO sujetoDTO = new SujetoDTO(sujetoDAO);
            listaSujetosDTO.add(sujetoDTO);
        }
        return listaSujetosDTO;
    }

    public SujetoDTO guardarSujeto(SujetoDTO sujetoDTO) {
        SujetoDAO sujetoDAO = sujetoDTO.toDAO();
        return new SujetoDTO(sujetoRepo.save(sujetoDAO));
    }

    public SujetoDAO guardarSujeto(SujetoDAO sujetoDAO) {
        return sujetoRepo.save(sujetoDAO);
    }

    public SujetoDTO obtenerSujeto(String dni) throws NoExisteElSujetoException {
        return new SujetoDTO(obtenerSujetoDAO(dni));
    }

    public SujetoDAO obtenerSujetoDAO(String dni) throws NoExisteElSujetoException {
        SujetoDAO sujetoDAO = null;
        Optional<SujetoDAO> sujetoOtional = sujetoRepo.findById(dni);
        if (sujetoOtional.isPresent()) {
            sujetoDAO = sujetoOtional.get();
        }
        else {
            throw new NoExisteElSujetoException("El sujeto no existe en la base de datos");
        }
        return sujetoDAO;
    }



}
