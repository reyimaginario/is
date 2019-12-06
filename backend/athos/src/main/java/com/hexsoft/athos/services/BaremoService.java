package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.FiltroBaremoDTO;
import com.hexsoft.athos.entities.BaremoDAO;
import com.hexsoft.athos.entities.SujetoAnonimo;
import com.hexsoft.athos.repositories.IBaremoRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaremoService {

    @Autowired
    private IBaremoRepo baremoRepo;

    public void guardarBaremo(BaremoDAO baremoDAO) {
        baremoRepo.save(baremoDAO);
    }

    public void guardarBaremo(SujetoAnonimo sujetoAnonimo, List<JSONObject> listaResultados) {

        JSONObject mmpi2 = listaResultados.get(0);  // primer test mmpi2

        JSONArray escalaBasica = (JSONArray)mmpi2.get("Basicas");
        JSONArray escalaContenido = (JSONArray)mmpi2.get("Contenido");
        JSONArray escalaSuplementaria = (JSONArray)mmpi2.get("Suplementarias");
        JSONArray escalaAdicional = (JSONArray)mmpi2.get("Adicionales de Validez");

        BaremoDAO baremoDAO = new BaremoDAO();

        // sujeto anonimo
        agregarSujetoAnonimo(baremoDAO, sujetoAnonimo);

        // escala basica
        agregarEscalaBasica(baremoDAO, escalaBasica);

        // escala contenido
        agregarEscalaContenido(baremoDAO, escalaContenido);

        // escala suplementaria
        agregarEscalaSuplementaria(baremoDAO, escalaSuplementaria);

        // escala Adicional
        agregarEscalaAdicional(baremoDAO, escalaAdicional);

        baremoRepo.save(baremoDAO);
    }

    private void agregarSujetoAnonimo(BaremoDAO baremoDAO, SujetoAnonimo sujetoAnonimo) {
        baremoDAO.setLocalidad(sujetoAnonimo.getLocalidad());
        baremoDAO.setEdad(sujetoAnonimo.getEdad());
        baremoDAO.setGenero(sujetoAnonimo.getGenero());
        baremoDAO.setNivelDeEstudio(sujetoAnonimo.getNivelDeEstudio());
        baremoDAO.setOcupacion(sujetoAnonimo.getOcupacion());
    }

    private void agregarEscalaBasica(BaremoDAO baremoDAO, JSONArray escalaBasica) {
        for (Object o : escalaBasica) {
            if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_L")) {
                baremoDAO.setBasica_l((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_F")) {
                baremoDAO.setBasica_f((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_K")) {
                baremoDAO.setBasica_k((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_HS")) {
                baremoDAO.setBasica_hs((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_D")) {
                baremoDAO.setBasica_d((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_HY")) {
                baremoDAO.setBasica_hy((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_PD")) {
                baremoDAO.setBasica_pd((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MF_M")) {
                baremoDAO.setBasica_mf_m((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MF_F")) {
                baremoDAO.setBasica_mf_f((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_PA")) {
                baremoDAO.setBasica_pa((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_PT")) {
                baremoDAO.setBasica_pt((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SC")) {
                baremoDAO.setBasica_sc((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MA")) {
                baremoDAO.setBasica_ma((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SI")) {
                baremoDAO.setBasica_si((Integer) ((JSONObject) o).get("PB"));
            }
        }
    }

    private void agregarEscalaContenido(BaremoDAO baremoDAO, JSONArray escalaContenido) {
        for (Object o : escalaContenido) {
            if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_ANX")) {
                baremoDAO.setContenido_anx((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_FRS")) {
                baremoDAO.setContenido_frs((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_OBS")) {
                baremoDAO.setContenido_obs((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_DEP")) {
                baremoDAO.setContenido_dep((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_HEA")) {
                baremoDAO.setContenido_hea((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_BIZ")) {
                baremoDAO.setContenido_biz((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_ANG")) {
                baremoDAO.setContenido_ang((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_CYN")) {
                baremoDAO.setContenido_cyn((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_ASP")) {
                baremoDAO.setContenido_asp((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_TPA")) {
                baremoDAO.setContenido_tpa((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_LSE")) {
                baremoDAO.setContenido_lse((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SOD")) {
                baremoDAO.setContenido_sod((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_FAM")) {
                baremoDAO.setContenido_fam((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_WRK")) {
                baremoDAO.setContenido_wrk((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_TRT")) {
                baremoDAO.setContenido_trt((Integer) ((JSONObject) o).get("PB"));
            }
        }
    }

    private void agregarEscalaSuplementaria(BaremoDAO baremoDAO, JSONArray escalaSuplementaria) {
        for (Object o : escalaSuplementaria) {
            if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_A")) {
                baremoDAO.setSuplementarias_a((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_R")) {
                baremoDAO.setSuplementarias_r((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_ES")) {
                baremoDAO.setSuplementarias_es((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MAC_R")) {
                baremoDAO.setSuplementarias_mac_r((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_O_H")) {
                baremoDAO.setSuplementarias_o_h((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_DO")) {
                baremoDAO.setSuplementarias_do((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_RE")) {
                baremoDAO.setSuplementarias_re((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MT")) {
                baremoDAO.setSuplementarias_mt((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_GM")) {
                baremoDAO.setSuplementarias_gm((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_GF")) {
                baremoDAO.setSuplementarias_gf((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_PK")) {
                baremoDAO.setSuplementarias_pk((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_PS")) {
                baremoDAO.setSuplementarias_ps((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SI1")) {
                baremoDAO.setSuplementarias_si1((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SI2")) {
                baremoDAO.setSuplementarias_si2((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SI3")) {
                baremoDAO.setSuplementarias_si3((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_MDS")) {
                baremoDAO.setSuplementarias_mds((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_APS")) {
                baremoDAO.setSuplementarias_aps((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_AAS")) {
                baremoDAO.setSuplementarias_aas((Integer) ((JSONObject) o).get("PB"));
            }
        }
    }

    private void agregarEscalaAdicional(BaremoDAO baremoDAO, JSONArray escalaAdicional) {
        for (Object o : escalaAdicional) {
            if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_FB_BACK")) {
                baremoDAO.setAdicionales_fb_back((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_F(P)")) {
                baremoDAO.setAdicionales_f_p((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_DS")) {
                baremoDAO.setAdicionales_ds((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_DS_R")) {
                baremoDAO.setAdicionales_ds_r((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_S")) {
                baremoDAO.setAdicionales_s((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SD")) {
                baremoDAO.setAdicionales_sd((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_SO")) {
                baremoDAO.setAdicionales_so((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_VRIN")) {
                baremoDAO.setAdicionales_vrin((Integer) ((JSONObject) o).get("PB"));
            }
            else if ( ((JSONObject) o).get("Escala").equals("SUBESCALA_TRIN")) {
                baremoDAO.setAdicionales_trin((Integer) ((JSONObject) o).get("PB"));
            }
        }
    }

    public List<BaremoDAO> obtenerTodosLosBaremo() {
        return baremoRepo.findAll();
    }

    public List<BaremoDAO> obtenerBaremosFiltradosSQL(FiltroBaremoDTO filtro) {
        return baremoRepo.obtenerBaremosFiltradosSQL(filtro.getLocalidad(), filtro.getEdadDesde(), filtro.getEdadHasta(), filtro.getGenero(), filtro.getNivelDeEstudio(), filtro.getOcupacion());
    }
}
