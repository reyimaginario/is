package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.dtos.SujetoDTO;
import com.hexsoft.athos.dtos.TestAplicadoDTO;
import com.hexsoft.athos.entities.*;
import com.hexsoft.athos.repositories.IEvaluacionPsicologicaRepo;
import com.hexsoft.athos.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public EvaluacionPsicologicaDTO obtenerEvaluacion(Long evaluacionId) {
        return new EvaluacionPsicologicaDTO(obtenerEvaluacionDAO(evaluacionId));
    }

    public EvaluacionPsicologicaDAO obtenerEvaluacionDAO(Long evaluacionId) {

        EvaluacionPsicologicaDAO evaluacionDAO = null;

        Optional<EvaluacionPsicologicaDAO> evaluacionDAOOptional = evaluacionPsicologicaRepo.findById(evaluacionId);

        if (evaluacionDAOOptional.isPresent()) {
            evaluacionDAO = evaluacionDAOOptional.get();
        }

        return evaluacionDAO;
    }

    private EvaluacionPsicologicaDAO guardarEvaluacion(EvaluacionPsicologicaDAO evaluacion) {
        return evaluacionPsicologicaRepo.save(evaluacion);
    }

    public boolean guardarRespuestaTemporal(RespuestaTemporalDTO respuestaTemporal) {

        boolean respuesta = false;
        EvaluacionPsicologicaDAO evaluacionDAO = obtenerEvaluacionDAO(respuestaTemporal.getEvaluacionId());
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO;

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

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = new EvaluacionPsicologicaDAO();
        String profesionalDni = evaluacionPsicologicaDTO.getProfesionalDTO().getDni();
        SujetoDTO sujetoDTOTmp = evaluacionPsicologicaDTO.getSujetoDTO();
        SujetoDTO sujetoDTO = sujetoService.guardarSujeto(sujetoDTOTmp);
        SujetoDAO sujetoDAO = sujetoDTO.toDAO();
        ProfesionalDAO profesionalDAO = profesionalService.obtenerProfesionalDAO(profesionalDni);

        Date fechaInicio = FechaUtils.obtenerFechaActual();
        String motivo = evaluacionPsicologicaDTO.getMotivo();
        evaluacionPsicologicaDAO.setProfesionalDAO(profesionalDAO);
        evaluacionPsicologicaDAO.setSujetoDAO(sujetoDAO);
        evaluacionPsicologicaDAO.setFechaInicio(fechaInicio);
        evaluacionPsicologicaDAO.setMotivo(motivo);
        EvaluacionPsicologicaDAO evaluacionTmp = evaluacionPsicologicaRepo.save(evaluacionPsicologicaDAO);

        List<TestAplicadoDTO> listaTestsAplicadosDTO = evaluacionPsicologicaDTO.getListaTestsAplicadosDTO();
        List<TestAplicadoDAO> listaTestsAplicadosDAOTmp = new ArrayList<>();
        for (TestAplicadoDTO testAplicadoDTO : listaTestsAplicadosDTO) {
            TestAplicadoDAO testAplicadoDAO = testAplicadoDTO.toDAO();
            testAplicadoDAO.setEvaluacionPsicologicaDAO(evaluacionTmp);
            listaTestsAplicadosDAOTmp.add(testAplicadoDAO);
        }

        evaluacionTmp.setProfesionalDAO(profesionalDAO);
        evaluacionTmp.setSujetoDAO(sujetoDAO);
        evaluacionTmp.setFechaInicio(fechaInicio);
        evaluacionTmp.setMotivo(motivo);
        evaluacionTmp.setListaTestsAplicadosDAO(listaTestsAplicadosDAOTmp);

        return new EvaluacionPsicologicaDTO(evaluacionPsicologicaRepo.save(evaluacionTmp));

    }

    public EvaluacionPsicologicaDTO finalizarEvaluacion(Long evaluacionId) {

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = null;
        Optional<EvaluacionPsicologicaDAO> evaluacionPsicologicaDAOOptional = evaluacionPsicologicaRepo.findById(evaluacionId);
        if (evaluacionPsicologicaDAOOptional.isPresent()) {
            evaluacionPsicologicaDAO = evaluacionPsicologicaDAOOptional.get();

            if (evaluacionPsicologicaDAO.getFinalizado() == 1) {
                return null;
            }

            respuestaTemporalService.finalizarRespuestas(evaluacionPsicologicaDAO);

            evaluacionPsicologicaDAO.setFechaFin(FechaUtils.obtenerFechaActual());
            evaluacionPsicologicaDAO.setFinalizado(1);
            evaluacionPsicologicaDAO.getRespuestasTemporalesDAO().clear();
            evaluacionPsicologicaRepo.save(evaluacionPsicologicaDAO);

        }

        return new EvaluacionPsicologicaDTO(evaluacionPsicologicaDAO);
    }

    public List<EvaluacionPsicologicaDTO> obtenerEvaluaciones() {
        List<EvaluacionPsicologicaDTO> listaEvaluacionesPsicologicasDTO = new ArrayList<>();
        List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO = evaluacionPsicologicaRepo.findAll();
        for (EvaluacionPsicologicaDAO evaluacionPsicologicaDAO : listaEvaluacionesPsicologicasDAO) {
            EvaluacionPsicologicaDTO evaluacionPsicologicaDTO = new EvaluacionPsicologicaDTO(evaluacionPsicologicaDAO);
            listaEvaluacionesPsicologicasDTO.add(evaluacionPsicologicaDTO);
        }
        return listaEvaluacionesPsicologicasDTO;
    }

    public List<RespuestaTemporalDTO> obtenerRespuestasTemporales(Long evaluacionId) {
        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = obtenerEvaluacionDAO(evaluacionId);
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO = evaluacionPsicologicaDAO.getRespuestasTemporalesDAO();
        List<RespuestaTemporalDTO> listaRespuestasTemporalesDTO = new ArrayList<>();
        for (RespuestaTemporalDAO respuestaTemporalDAO : listaRespuestasTemporalesDAO) {
            RespuestaTemporalDTO respuestaTemporalDTO = new RespuestaTemporalDTO(respuestaTemporalDAO);
            listaRespuestasTemporalesDTO.add(respuestaTemporalDTO);
        }
        return listaRespuestasTemporalesDTO;
    }
}
