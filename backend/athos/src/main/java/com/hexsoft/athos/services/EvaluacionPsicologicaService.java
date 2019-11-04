package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.repositories.IEvaluacionPsicologicaRepo;
import com.hexsoft.athos.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionPsicologicaService {

    @Autowired
    private IEvaluacionPsicologicaRepo evaluacionPsicologicaRepo;

    @Autowired
    private RespuestaTemporalService respuestaTemporalService;

    @Autowired
    private SujetoService sujetoService;

    @Autowired
    private ProfesionalService profesionalService;


    public EvaluacionPsicologicaDAO obtenerEvaluacion(Long evaluacionId) {

        EvaluacionPsicologicaDAO evaluacionDAO = null;

        Optional<EvaluacionPsicologicaDAO> evaluacionDAOOptional = evaluacionPsicologicaRepo.findById(evaluacionId);

        if (evaluacionDAOOptional.isPresent()) {
            evaluacionDAO = evaluacionDAOOptional.get();
        }

        return evaluacionDAO;
    }

    public EvaluacionPsicologicaDAO guardarEvaluacion(EvaluacionPsicologicaDAO evaluacion) {
        return evaluacionPsicologicaRepo.save(evaluacion);
    }

    public boolean guardarRespuestaTemporal(RespuestaTemporalDTO respuestaTemporal) {

        boolean respuesta = false;
        EvaluacionPsicologicaDAO evaluacionDAO = obtenerEvaluacion(respuestaTemporal.getEvaluacionId());
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO = null;

        RespuestaTemporalDAO respuestaTemporalDAO = new RespuestaTemporalDAO(respuestaTemporal.getTestCode()
                                                                            ,respuestaTemporal.getPregunta()
                                                                            ,respuestaTemporal.getRespuesta());

        if (evaluacionDAO != null) {
            listaRespuestasTemporalesDAO = evaluacionDAO.getRespuestasTemporalesDAO();
            listaRespuestasTemporalesDAO.add(respuestaTemporalDAO);
            evaluacionDAO.setRespuestasTemporalesDAO(listaRespuestasTemporalesDAO);
            evaluacionPsicologicaRepo.save(evaluacionDAO);
            respuesta = true;
        }

        return respuesta;
    }

    public EvaluacionPsicologicaDTO crearEvaluacion(EvaluacionPsicologicaDTO evaluacionPsicologicaDTO) {
        String profesionalDni = evaluacionPsicologicaDTO.getProfesionalDTO().getDni();
        String sujetoDni = evaluacionPsicologicaDTO.getSujetoDTO().getDni();
        ProfesionalDAO profesionalDAO = profesionalService.obtenerProfesionalDAO(profesionalDni);
        SujetoDAO sujetoDAO = sujetoService.obtenerSujetoDAO(sujetoDni);
        Date fechaInicio = FechaUtils.stringToDate(evaluacionPsicologicaDTO.getFechaInicio());
        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = new EvaluacionPsicologicaDAO();
        evaluacionPsicologicaDAO.setProfesionalDAO(profesionalDAO);
        evaluacionPsicologicaDAO.setSujetoDAO(sujetoDAO);
        evaluacionPsicologicaDAO.setFechaInicio(fechaInicio);

        EvaluacionPsicologicaDAO evaluacionTmp = evaluacionPsicologicaRepo.save(evaluacionPsicologicaDAO);

        return new EvaluacionPsicologicaDTO(evaluacionTmp);
    }


    public EvaluacionPsicologicaDTO finalizarEvaluacion(Long evaluacionId) {

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = null;
        Optional<EvaluacionPsicologicaDAO> evaluacionPsicologicaDAOOptional = evaluacionPsicologicaRepo.findById(evaluacionId);
        if (evaluacionPsicologicaDAOOptional.isPresent()) {
            evaluacionPsicologicaDAO = evaluacionPsicologicaDAOOptional.get();

            for (RespuestaTemporalDAO respuestaTemporalDAO : evaluacionPsicologicaDAO.getRespuestasTemporalesDAO()) {

            }
        }


    }

}
