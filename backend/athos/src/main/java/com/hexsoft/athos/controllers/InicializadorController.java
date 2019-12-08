package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.ProfesionalDTO;
import com.hexsoft.athos.entities.*;
import com.hexsoft.athos.exceptions.NoExisteElProfesionalException;
import com.hexsoft.athos.services.*;
import com.hexsoft.athos.utils.FechaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/iniciar")
public class InicializadorController {

    @Autowired
    private ProfesionalService profesionalService;
    @Autowired
    private GeneroService generoService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private LocalodadService localodadService;
    @Autowired
    private OcupacionService ocupacionService;
    @Autowired
    private SujetoService sujetoService;
    @Autowired
    private EvaluacionPsicologicaService evaluacionService;
    @Autowired
    private TestAplicadoService testAplicadoService;
    @Autowired
    private RespuestaTemporalService respuestaTemporalService;
    @Autowired
    private BaremoService baremoService;

    @GetMapping
    public void inicializar() {

        cargarGeneros();
        cargarEstudios();
        cargarLocalidades();
        cargarOcupaciones();
        cargarProfesionales();
        cargarEvaluaciones();
        cargarBaremos();

    }


    private void cargarGeneros() {
        GeneroDAO generoDAO;

        generoDAO = new GeneroDAO("Femenino");
        generoService.guardarGenero(generoDAO);
        generoDAO = new GeneroDAO("Masculino");
        generoService.guardarGenero(generoDAO);
        generoDAO = new GeneroDAO("Otro");
        generoService.guardarGenero(generoDAO);

    }

    private void cargarEstudios() {
        EstudioDAO estudioDAO;

        estudioDAO = new EstudioDAO("Primario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Secundario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Terciario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Universitario");
        estudioService.guardarEstudio(estudioDAO);
        estudioDAO = new EstudioDAO("Postgrado");
        estudioService.guardarEstudio(estudioDAO);

    }

    private void cargarLocalidades() {
        LocalidadDAO localidadDAO;

        localidadDAO = new LocalidadDAO("CABA");
        localodadService.guardarLocalidad(localidadDAO);
        localidadDAO = new LocalidadDAO("Buenos Aires");
        localodadService.guardarLocalidad(localidadDAO);

    }

    private void cargarOcupaciones() {
        OcupacionDAO ocupacionDAO;

        ocupacionDAO = new OcupacionDAO("Estudiante");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Programador");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Docente");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Locutor");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Periodista");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Musico");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Vendedor");
        ocupacionService.guardarOcupacion(ocupacionDAO);
        ocupacionDAO = new OcupacionDAO("Otra");
        ocupacionService.guardarOcupacion(ocupacionDAO);

    }

    private void cargarProfesionales() {
        ProfesionalDTO profesionalDTO = null;

        profesionalDTO = new ProfesionalDTO("11222333", "Sigmund", "Freud", "1", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);
        profesionalDTO = new ProfesionalDTO("22333444", "Jacques", "Lacan", "2", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);
        profesionalDTO = new ProfesionalDTO("33444555", "Carl",    "Jung",  "3", new ArrayList<>());
        profesionalService.guardarProfesional(profesionalDTO);

    }

    private void cargarEvaluaciones() {
        EvaluacionPsicologicaDAO evaluacionDAO = null;
        SujetoDAO sujetoDAO = null;
        ProfesionalDAO profesionalDAO = null;
        TestAplicadoDAO testAplicadoDAO = null;
        List<TestAplicadoDAO> listaTestAplicadosDAO = null;
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO = null;
        RespuestaTemporalDAO respuestaTemporalDAO = null;


        evaluacionDAO = new EvaluacionPsicologicaDAO();
        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);

        try {
            profesionalDAO = profesionalService.obtenerProfesionalDAO("11222333");
        } catch (NoExisteElProfesionalException e) {
            e.printStackTrace();
        }

        sujetoDAO = new SujetoDAO("30303303", "Augusto", "Maravilla", "CABA", "34", "Masculino", "Terciario", "Programador", profesionalDAO, new ArrayList<>());
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);

        List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO = sujetoDAO.getListaEvaluacionesPsicologicasDAO();
        listaEvaluacionesPsicologicasDAO.add(evaluacionDAO);
        sujetoDAO.setListaEvaluacionesPsicologicasDAO(listaEvaluacionesPsicologicasDAO);
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);

        List<SujetoDAO> listaSujetosDAO = profesionalDAO.getListaSujetosDAO();
        listaSujetosDAO.add(sujetoDAO);
        profesionalDAO.setListaSujetosDAO(listaSujetosDAO);
        profesionalDAO = profesionalService.guardarProfesional(profesionalDAO);

        testAplicadoDAO = new TestAplicadoDAO();
        testAplicadoDAO.setTestCode("MMPI2");
        testAplicadoDAO.setEvaluacionPsicologicaDAO(evaluacionDAO);
        testAplicadoDAO = testAplicadoService.guardarTestAplicado(testAplicadoDAO);
        listaTestAplicadosDAO = new ArrayList<>();
        listaTestAplicadosDAO.add(testAplicadoDAO);

        evaluacionDAO.setFechaInicio(FechaUtils.stringToDate("2019-12-01"));
        evaluacionDAO.setMotivo("Psicotecnico");
        evaluacionDAO.setProfesionalDAO(profesionalDAO);
        evaluacionDAO.setSujetoDAO(sujetoDAO);
        evaluacionDAO.setListaTestsAplicadosDAO(listaTestAplicadosDAO);

        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);


        listaRespuestasTemporalesDAO = generarRespuestasTemporalesAleatorias(evaluacionDAO);

        evaluacionDAO.setRespuestasTemporalesDAO(listaRespuestasTemporalesDAO);
        evaluacionService.guardarEvaluacion(evaluacionDAO);
        evaluacionService.finalizarEvaluacion(evaluacionDAO.getEvaluacionId());


        //  ----


        evaluacionDAO = new EvaluacionPsicologicaDAO();
        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);

        listaEvaluacionesPsicologicasDAO = sujetoDAO.getListaEvaluacionesPsicologicasDAO();
        listaEvaluacionesPsicologicasDAO.add(evaluacionDAO);
        sujetoDAO.setListaEvaluacionesPsicologicasDAO(listaEvaluacionesPsicologicasDAO);
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);

        testAplicadoDAO = new TestAplicadoDAO();
        testAplicadoDAO.setTestCode("MMPI2");
        testAplicadoDAO.setEvaluacionPsicologicaDAO(evaluacionDAO);
        testAplicadoDAO = testAplicadoService.guardarTestAplicado(testAplicadoDAO);
        listaTestAplicadosDAO = new ArrayList<>();
        listaTestAplicadosDAO.add(testAplicadoDAO);

        evaluacionDAO.setFechaInicio(FechaUtils.stringToDate("2018-06-01"));
        evaluacionDAO.setMotivo("Psicotecnico");
        evaluacionDAO.setProfesionalDAO(profesionalDAO);
        evaluacionDAO.setSujetoDAO(sujetoDAO);
        evaluacionDAO.setListaTestsAplicadosDAO(listaTestAplicadosDAO);

        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);

        listaRespuestasTemporalesDAO = generarRespuestasTemporalesAleatorias(evaluacionDAO);

        evaluacionDAO.setRespuestasTemporalesDAO(listaRespuestasTemporalesDAO);
        evaluacionService.guardarEvaluacion(evaluacionDAO);
        evaluacionService.finalizarEvaluacion(evaluacionDAO.getEvaluacionId());


        //  ----


        sujetoDAO = new SujetoDAO("20202202", "Teddy", "Daniels", "CABA", "30", "Masculino", "Universitario", "Periodista", profesionalDAO, new ArrayList<>());
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);

        evaluacionDAO = new EvaluacionPsicologicaDAO();
        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);

        listaEvaluacionesPsicologicasDAO = sujetoDAO.getListaEvaluacionesPsicologicasDAO();
        listaEvaluacionesPsicologicasDAO.add(evaluacionDAO);
        sujetoDAO.setListaEvaluacionesPsicologicasDAO(listaEvaluacionesPsicologicasDAO);
        sujetoDAO = sujetoService.guardarSujeto(sujetoDAO);

        testAplicadoDAO = new TestAplicadoDAO();
        testAplicadoDAO.setTestCode("MMPI2");
        testAplicadoDAO.setEvaluacionPsicologicaDAO(evaluacionDAO);
        testAplicadoDAO = testAplicadoService.guardarTestAplicado(testAplicadoDAO);
        listaTestAplicadosDAO = new ArrayList<>();
        listaTestAplicadosDAO.add(testAplicadoDAO);

        evaluacionDAO.setFechaInicio(FechaUtils.stringToDate("2019-07-01"));
        evaluacionDAO.setMotivo("Psicotecnico");
        evaluacionDAO.setProfesionalDAO(profesionalDAO);
        evaluacionDAO.setSujetoDAO(sujetoDAO);
        evaluacionDAO.setListaTestsAplicadosDAO(listaTestAplicadosDAO);

        evaluacionDAO = evaluacionService.guardarEvaluacion(evaluacionDAO);

        listaRespuestasTemporalesDAO = generarRespuestasTemporalesAleatorias(evaluacionDAO);

        evaluacionDAO.setRespuestasTemporalesDAO(listaRespuestasTemporalesDAO);
        evaluacionService.guardarEvaluacion(evaluacionDAO);
        evaluacionService.finalizarEvaluacion(evaluacionDAO.getEvaluacionId());



    }

    private List<RespuestaTemporalDAO> generarRespuestasTemporalesAleatorias(EvaluacionPsicologicaDAO evaluacionDAO) {
        List<RespuestaTemporalDAO> listaRespuestasTemporalesDAO = new ArrayList<>();
        RespuestaTemporalDAO respuestaTemporalDAO = null;
        int n;
        for (int i=1; i<=567; i++) {
            respuestaTemporalDAO = new RespuestaTemporalDAO();
            respuestaTemporalDAO.setEvaluacionPsicologicaDAO(evaluacionDAO);
            respuestaTemporalDAO.setTestCode("MMPI2");
            respuestaTemporalDAO.setPregunta(i);
            n = (int)(Math.random() * 3 + 1);
            if (n == 1) { respuestaTemporalDAO.setRespuesta(-1); }
            else if (n == 2) { respuestaTemporalDAO.setRespuesta(0); }
            else if (n == 3) { respuestaTemporalDAO.setRespuesta(1); }
            respuestaTemporalDAO = respuestaTemporalService.guardarRespuestaTemporal(respuestaTemporalDAO);
            listaRespuestasTemporalesDAO.add(respuestaTemporalDAO);
        }
        return listaRespuestasTemporalesDAO;
    }

    private void cargarBaremos() {
        BaremoDAO baremoDAO;


        for (int i=0; i<50; i++) {
            baremoDAO = new BaremoDAO();

            baremoDAO.setLocalidad("CABA");
            baremoDAO.setEdad(Integer.toString((int)(Math.random() * 10 + 1) + 25));
            baremoDAO.setGenero("Masculino");
            baremoDAO.setNivelDeEstudio("Terciario");
            baremoDAO.setOcupacion("Programador");

            baremoDAO.setBasica_l((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_f((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_k((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hs((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_d((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hy((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_pd((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_mf_m((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_mf_f((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_pa((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_pt((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_sc((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_ma((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_si((int)(Math.random() * 45 + 15));

            baremoDAO.setContenido_anx((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_frs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_obs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_dep((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_hea((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_biz((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_ang((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_cyn((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_asp((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_tpa((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_lse((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_sod((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_fam((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_wrk((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_trt((int)(Math.random() * 30 + 1));

            baremoDAO.setSuplementarias_a((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_es((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_mac_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_o_h((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_do((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_re((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_mt((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_gm((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_gf((int)(Math.random() * 50 + 20));
            baremoDAO.setSuplementarias_pk((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_ps((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si1((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si2((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si3((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_mds((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_aps((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_aas((int)(Math.random() * 30 + 1));

            baremoDAO.setAdicionales_fb_back((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_f_p((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds_r((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_s((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_sd((int)(Math.random() * 35 + 5));
            baremoDAO.setAdicionales_so((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_vrin((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_trin((int)(Math.random() * 30 + 1));

            baremoService.guardarBaremo(baremoDAO);
        }


        for (int i=0; i<50; i++) {
            baremoDAO = new BaremoDAO();

            baremoDAO.setLocalidad("CABA");
            baremoDAO.setEdad(Integer.toString((int)(Math.random() * 10 + 1) + 23));
            baremoDAO.setGenero("Femenino");
            baremoDAO.setNivelDeEstudio("Terciario");
            baremoDAO.setOcupacion("Programador");

            baremoDAO.setBasica_l((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_f((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_k((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hs((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_d((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hy((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_pd((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_mf_m((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_mf_f((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_pa((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_pt((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_sc((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_ma((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_si((int)(Math.random() * 45 + 15));

            baremoDAO.setContenido_anx((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_frs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_obs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_dep((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_hea((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_biz((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_ang((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_cyn((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_asp((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_tpa((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_lse((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_sod((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_fam((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_wrk((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_trt((int)(Math.random() * 30 + 1));

            baremoDAO.setSuplementarias_a((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_es((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_mac_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_o_h((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_do((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_re((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_mt((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_gm((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_gf((int)(Math.random() * 50 + 20));
            baremoDAO.setSuplementarias_pk((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_ps((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si1((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si2((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si3((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_mds((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_aps((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_aas((int)(Math.random() * 30 + 1));

            baremoDAO.setAdicionales_fb_back((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_f_p((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds_r((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_s((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_sd((int)(Math.random() * 35 + 5));
            baremoDAO.setAdicionales_so((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_vrin((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_trin((int)(Math.random() * 30 + 1));

            baremoService.guardarBaremo(baremoDAO);
        }


        for (int i=0; i<25; i++) {
            baremoDAO = new BaremoDAO();

            baremoDAO.setLocalidad("CABA");
            baremoDAO.setEdad(Integer.toString((int)(Math.random() * 10 + 1) + 25));
            baremoDAO.setGenero("Femenino");
            baremoDAO.setNivelDeEstudio("Universitario");
            baremoDAO.setOcupacion("Locutor");

            baremoDAO.setBasica_l((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_f((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_k((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hs((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_d((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hy((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_pd((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_mf_m((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_mf_f((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_pa((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_pt((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_sc((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_ma((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_si((int)(Math.random() * 45 + 15));

            baremoDAO.setContenido_anx((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_frs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_obs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_dep((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_hea((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_biz((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_ang((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_cyn((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_asp((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_tpa((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_lse((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_sod((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_fam((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_wrk((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_trt((int)(Math.random() * 30 + 1));

            baremoDAO.setSuplementarias_a((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_es((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_mac_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_o_h((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_do((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_re((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_mt((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_gm((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_gf((int)(Math.random() * 50 + 20));
            baremoDAO.setSuplementarias_pk((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_ps((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si1((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si2((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si3((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_mds((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_aps((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_aas((int)(Math.random() * 30 + 1));

            baremoDAO.setAdicionales_fb_back((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_f_p((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds_r((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_s((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_sd((int)(Math.random() * 35 + 5));
            baremoDAO.setAdicionales_so((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_vrin((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_trin((int)(Math.random() * 30 + 1));

            baremoService.guardarBaremo(baremoDAO);
        }


        for (int i=0; i<25; i++) {
            baremoDAO = new BaremoDAO();

            baremoDAO.setLocalidad("CABA");
            baremoDAO.setEdad(Integer.toString((int)(Math.random() * 10 + 1) + 28));
            baremoDAO.setGenero("Otro");
            baremoDAO.setNivelDeEstudio("Universitario");
            baremoDAO.setOcupacion("Musico");

            baremoDAO.setBasica_l((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_f((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_k((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hs((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_d((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_hy((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_pd((int)(Math.random() * 35 + 5));
            baremoDAO.setBasica_mf_m((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_mf_f((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_pa((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_pt((int)(Math.random() * 45 + 15));
            baremoDAO.setBasica_sc((int)(Math.random() * 40 + 10));
            baremoDAO.setBasica_ma((int)(Math.random() * 30 + 1));
            baremoDAO.setBasica_si((int)(Math.random() * 45 + 15));

            baremoDAO.setContenido_anx((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_frs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_obs((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_dep((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_hea((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_biz((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_ang((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_cyn((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_asp((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_tpa((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_lse((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_sod((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_fam((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_wrk((int)(Math.random() * 30 + 1));
            baremoDAO.setContenido_trt((int)(Math.random() * 30 + 1));

            baremoDAO.setSuplementarias_a((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_es((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_mac_r((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_o_h((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_do((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_re((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_mt((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_gm((int)(Math.random() * 45 + 15));
            baremoDAO.setSuplementarias_gf((int)(Math.random() * 50 + 20));
            baremoDAO.setSuplementarias_pk((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_ps((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si1((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si2((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_si3((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_mds((int)(Math.random() * 30 + 1));
            baremoDAO.setSuplementarias_aps((int)(Math.random() * 35 + 5));
            baremoDAO.setSuplementarias_aas((int)(Math.random() * 30 + 1));

            baremoDAO.setAdicionales_fb_back((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_f_p((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_ds_r((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_s((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_sd((int)(Math.random() * 35 + 5));
            baremoDAO.setAdicionales_so((int)(Math.random() * 45 + 15));
            baremoDAO.setAdicionales_vrin((int)(Math.random() * 30 + 1));
            baremoDAO.setAdicionales_trin((int)(Math.random() * 30 + 1));

            baremoService.guardarBaremo(baremoDAO);
        }

    }


}
