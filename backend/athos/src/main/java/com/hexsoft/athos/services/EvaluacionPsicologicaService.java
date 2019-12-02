package com.hexsoft.athos.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexsoft.athos.dtos.*;
import com.hexsoft.athos.dtos.wrapper.ListaRespuestasTemporalesDTO;
import com.hexsoft.athos.entities.*;
import com.hexsoft.athos.exceptions.NoExisteElProfesionalException;
import com.hexsoft.athos.exceptions.NoExisteElSujetoException;
import com.hexsoft.athos.repositories.IEvaluacionPsicologicaRepo;
import com.hexsoft.athos.test.ATest;
import com.hexsoft.athos.utils.FechaUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionPsicologicaService {

    private static final Integer FINALIZADO = 1;
    private static final Integer NO_FINALIZADO = 0;


    @Autowired
    private IEvaluacionPsicologicaRepo evaluacionPsicologicaRepo;

    @Autowired
    private RespuestaTemporalService respuestaTemporalService;

    @Autowired
    private SujetoService sujetoService;

    @Autowired
    private ProfesionalService profesionalService;

    @Autowired
    private TestAplicadoService testAplicadoService;

    @Autowired
    private BaremoService baremoService;

    private TestService testService = TestService.getInstance();


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

        RespuestaTemporalDAO respuestaTemporalDAO = new RespuestaTemporalDAO();
        respuestaTemporalDAO = respuestaTemporalService.guardarRespuestaTemporal(respuestaTemporalDAO);
        respuestaTemporalDAO.setTestCode(respuestaTemporal.getTestCode());
        respuestaTemporalDAO.setPregunta(respuestaTemporal.getPregunta());
        respuestaTemporalDAO.setRespuesta(respuestaTemporal.getRespuesta());
        respuestaTemporalDAO.setEvaluacionPsicologicaDAO(evaluacionDAO);
        respuestaTemporalDAO = respuestaTemporalService.guardarRespuestaTemporal(respuestaTemporalDAO);

        if (evaluacionDAO != null) {
            listaRespuestasTemporalesDAO = evaluacionDAO.getRespuestasTemporalesDAO();
            listaRespuestasTemporalesDAO.add(respuestaTemporalDAO);
            evaluacionDAO.setRespuestasTemporalesDAO(listaRespuestasTemporalesDAO);
            evaluacionPsicologicaRepo.save(evaluacionDAO);
            respuesta = true;
        }

        return respuesta;
    }

    public boolean guardarTodasLasRespuestasTemporales(ListaRespuestasTemporalesDTO listaRespuestasTemporalesDTO) {
        for (RespuestaTemporalDTO respuestaTemporalDTO : listaRespuestasTemporalesDTO.getListaRespuestasTemporalesDTO()) {
            guardarRespuestaTemporal(respuestaTemporalDTO);
        }
        return true;
    }

    public EvaluacionPsicologicaDTO crearEvaluacion(EvaluacionPsicologicaDTO evaluacionPsicologicaDTO) throws NoExisteElProfesionalException {

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = new EvaluacionPsicologicaDAO();
        evaluacionPsicologicaDAO = evaluacionPsicologicaRepo.save(evaluacionPsicologicaDAO);

        String profesionalDni = evaluacionPsicologicaDTO.getProfesionalDTO().getDni();
        String sujetoDni      = evaluacionPsicologicaDTO.getSujetoDTO().getDni();

        //SujetoDTO sujetoDTOTmp = evaluacionPsicologicaDTO.getSujetoDTO();
        //SujetoDTO sujetoDTO = sujetoService.guardarSujeto(sujetoDTOTmp);
        //SujetoDAO sujetoDAO = sujetoDTO.toDAO();
        ProfesionalDAO profesionalDAO = profesionalService.obtenerProfesionalDAO(profesionalDni);

        SujetoDAO sujetoDAO = null;
        try {
            sujetoDAO = sujetoService.obtenerSujetoDAO(sujetoDni);
        }
        catch (NoExisteElSujetoException e) {
            SujetoDTO sujetoDTO = evaluacionPsicologicaDTO.getSujetoDTO();
            sujetoDAO = sujetoDTO.toDAO();
        }

        List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO = sujetoDAO.getListaEvaluacionesPsicologicasDAO();
        listaEvaluacionesPsicologicasDAO.add(evaluacionPsicologicaDAO);
        sujetoDAO.setListaEvaluacionesPsicologicasDAO(listaEvaluacionesPsicologicasDAO);
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);


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
            String testCode = testAplicadoDTO.getTestCode();
            TestAplicadoDAO testAplicadoDAO = new TestAplicadoDAO();
            testAplicadoDAO.setTestCode(testCode);
            testAplicadoDAO = testAplicadoService.guardarTestAplicado(testAplicadoDAO);
            testAplicadoDAO.setEvaluacionPsicologicaDAO(evaluacionTmp);
            listaTestsAplicadosDAOTmp.add(testAplicadoDAO);
        }

        evaluacionTmp.setProfesionalDAO(profesionalDAO);
        evaluacionTmp.setSujetoDAO(sujetoDAO);
        evaluacionTmp.setFechaInicio(fechaInicio);
        evaluacionTmp.setMotivo(motivo);
        evaluacionTmp.setListaTestsAplicadosDAO(listaTestsAplicadosDAOTmp);
        evaluacionTmp.setFinalizado(NO_FINALIZADO);

        EvaluacionPsicologicaDTO evaluacionDTO = new EvaluacionPsicologicaDTO(evaluacionPsicologicaRepo.save(evaluacionTmp));

        return evaluacionDTO;

    }

    public EvaluacionPsicologicaDTO finalizarEvaluacion(Long evaluacionId) {

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = null;
        Optional<EvaluacionPsicologicaDAO> evaluacionPsicologicaDAOOptional = evaluacionPsicologicaRepo.findById(evaluacionId);
        if (evaluacionPsicologicaDAOOptional.isPresent()) {
            evaluacionPsicologicaDAO = evaluacionPsicologicaDAOOptional.get();

            if (evaluacionPsicologicaDAO.getFinalizado() == FINALIZADO) {
                return null;
            }

            respuestaTemporalService.finalizarRespuestas(evaluacionPsicologicaDAO);

            evaluacionPsicologicaDAO.setFechaFin(FechaUtils.obtenerFechaActual());
            evaluacionPsicologicaDAO.setFinalizado(FINALIZADO);
            evaluacionPsicologicaDAO.getRespuestasTemporalesDAO().clear();
            evaluacionPsicologicaRepo.save(evaluacionPsicologicaDAO);

        }

        agregarBaremo(evaluacionId);

        return new EvaluacionPsicologicaDTO(evaluacionPsicologicaDAO);
    }

    private void agregarBaremo(Long evaluacionId) {

        List<JSONObject> listaResultados = calcularEvaluacion(evaluacionId);

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = obtenerEvaluacionDAO(evaluacionId);
        SujetoDAO sujetoDAO = evaluacionPsicologicaDAO.getSujetoDAO();
        SujetoAnonimo sujetoAnonimo = new SujetoAnonimo( sujetoDAO.getLocalidad()
                                                        ,sujetoDAO.getEdad()
                                                        ,sujetoDAO.getGenero()
                                                        ,sujetoDAO.getNivelDeEstudio()
                                                        ,sujetoDAO.getOcupacion());

        baremoService.guardarBaremo(sujetoAnonimo, listaResultados);
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

    public List<JSONObject> calcularEvaluacion(Long evaluacionId) {

        List<JSONObject> listaCalculos = new ArrayList<>();
        TestService testService = TestService.getInstance();
        ATest test = null;

        EvaluacionPsicologicaDAO evaluacionDAO = obtenerEvaluacionDAO(evaluacionId);
        for (TestAplicadoDAO testAplicadoDAO : evaluacionDAO.getListaTestsAplicadosDAO()) {
            JSONObject calculo = null;
            test = testService.obtenerTest(testAplicadoDAO.getTestCode().toUpperCase());
            calculo = test.procesarRespuestas(testAplicadoDAO.getListaRespuestasDAO());
            listaCalculos.add(calculo);
        }

        return listaCalculos;

    }

}
