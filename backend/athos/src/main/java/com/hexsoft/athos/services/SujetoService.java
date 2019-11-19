package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.SujetoDAO;
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

    public SujetoDTO obtenerSujeto(String dni) {
        return new SujetoDTO(obtenerSujetoDAO(dni));
    }

    public SujetoDAO obtenerSujetoDAO(String dni) {
        SujetoDAO sujetoDAO = null;
        Optional<SujetoDAO> sujetoOtional = sujetoRepo.findById(dni);
        if (sujetoOtional.isPresent()) {
            sujetoDAO = sujetoOtional.get();
        }
        return sujetoDAO;
    }



    /*
    public List<EvaluacionPsicologicaDAO> obtenerEvaluacionesPsicologicas(String dni) {
        SujetoDAO sujetoDAO = getSujeto(dni);
        return sujetoDAO.getListaEvaluacionesPsicologicas();
    }
*/



/*    public List<SujetoDAO> obtenerSujetosPorProfesional(String profesionalDNI) {
        return sujetoRepo.findByDni(profesionalDNI);
    }*/

}
