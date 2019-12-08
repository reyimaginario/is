package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.dtos.wrapper.ListaRespuestasTemporalesDTO;
import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.RespuestaDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.entities.TestAplicadoDAO;
import com.hexsoft.athos.exceptions.NoExisteLaRespuestaTemporal;
import com.hexsoft.athos.repositories.IRespuestaTemporalRepo;
import com.hexsoft.athos.repositories.ISujetoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaTemporalService {

    @Autowired
    private IRespuestaTemporalRepo respuestaTemporalRepo;

    @Autowired
    private TestAplicadoService testAplicadoService;

    @Autowired
    private RespuestaService respuestaService;


    public RespuestaTemporalDAO obtenerRespuestaTemporal(Long respuestaTemporalId) throws NoExisteLaRespuestaTemporal {
        RespuestaTemporalDAO respuestaTemporalDAO = null;
        Optional<RespuestaTemporalDAO> respuestaTemporaOlptional = respuestaTemporalRepo.findById(respuestaTemporalId);
        if (respuestaTemporaOlptional.isPresent()) {
            respuestaTemporalDAO = respuestaTemporaOlptional.get();
        }
        else {
            throw new NoExisteLaRespuestaTemporal("La respuesta temporal no existe en la base de datos");
        }
        return respuestaTemporalDAO;
    }


    public void finalizarRespuestas(EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {

        Long evaluacionId = evaluacionPsicologicaDAO.getEvaluacionId();
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO = evaluacionPsicologicaDAO.getRespuestasTemporalesDAO();
        List<TestAplicadoDAO> listaTestsAplicadosDAO = evaluacionPsicologicaDAO.getListaTestsAplicadosDAO();
        if (listaRespuestasTemporalesDAO == null) {
            listaRespuestasTemporalesDAO = new ArrayList<>();
        }

        for (RespuestaTemporalDAO respuestaTemporalDAO : listaRespuestasTemporalesDAO) {
            String testCode = respuestaTemporalDAO.getTestCode();
            TestAplicadoDAO testAplicadoDAO = null;
            RespuestaDAO respuestaDAOTmp = temporalAFinal(respuestaTemporalDAO);
            // TODO hacer el save de la respuesta DAO primero y seguir laburando
            RespuestaDAO respuestaDAO = respuestaService.guardar(respuestaDAOTmp);
            // TODO falta setearle el testAplicadoDAO
            int i = 0;
            boolean seguirBuscando = true;

            while (i < listaTestsAplicadosDAO.size() && seguirBuscando) {
                if (listaTestsAplicadosDAO.get(i).getTestCode().equals(testCode)) {
                    testAplicadoDAO = listaTestsAplicadosDAO.get(i);
                    seguirBuscando = false;
                }
            }

            if (testAplicadoDAO != null) {
                if (testAplicadoDAO.getListaRespuestasDAO() == null) {    // .isempty  o no  TODO
                    testAplicadoDAO.setListaRespuestasDAO(new ArrayList<RespuestaDAO>());
                }
                respuestaDAO.setTestAplicadoDAO(testAplicadoDAO);
                respuestaService.guardar(respuestaDAO);
                List<RespuestaDAO> listaRespuestasDAOTmp = testAplicadoDAO.getListaRespuestasDAO();
                listaRespuestasDAOTmp.add(respuestaDAO);
                testAplicadoDAO.setListaRespuestasDAO(listaRespuestasDAOTmp);

                testAplicadoService.guardarTestAplicado(testAplicadoDAO);      // TODO respuestaID = null & testAplicadoDAO = null
            }

        }

    }


    private RespuestaDAO temporalAFinal(RespuestaTemporalDAO respuestaTemporalDAO) {
        RespuestaDAO respuestaDAO = new RespuestaDAO();
        respuestaDAO.setPregunta(respuestaTemporalDAO.getPregunta());
        respuestaDAO.setRespuesta(respuestaTemporalDAO.getRespuesta());
        return respuestaDAO;
    }


    public RespuestaTemporalDAO guardarRespuestaTemporal(RespuestaTemporalDAO respuestaTemporalDAO) {
        return respuestaTemporalRepo.save(respuestaTemporalDAO);
    }

    public RespuestaTemporalDAO actualizarRespuestaTemporal(RespuestaTemporalDTO respuestaTemporal) throws NoExisteLaRespuestaTemporal {
        RespuestaTemporalDAO respuestaTemporalDAO = obtenerRespuestaTemporal(respuestaTemporal.getRespuestaTemporalId());
        respuestaTemporalDAO.setRespuesta(respuestaTemporal.getRespuesta());
        respuestaTemporalDAO = respuestaTemporalRepo.save(respuestaTemporalDAO);
        return respuestaTemporalDAO;
    }
}
