package com.hexsoft.athos.services;

import com.hexsoft.athos.dtos.FiltroBaremoDTO;
import com.hexsoft.athos.entities.BaremoDAO;
import com.hexsoft.athos.entities.SujetoAnonimo;
import com.hexsoft.athos.repositories.IBaremoRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BaremoService {

	private static int RANGOS = 10;
	
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
    
    public JSONArray parsearBaremosParaGraficoDeDispersion(List<BaremoDAO> baremosFiltrados){
    	JSONArray result = new JSONArray();
    	JSONObject item = null;
    	for (BaremoDAO bDAO : baremosFiltrados) {
    		item =  new JSONObject();
    		item.put("type", "scatter");
    		item.put("toolTipContent", "<b>Valor:</b>{y}");
    		item.put("dataPoints", construirPuntosParaGraficoDeDispersion(bDAO));
    		result.add(item);
		}
    	return result;
    }

	private JSONArray construirPuntosParaGraficoDeDispersion(BaremoDAO bDAO) {
		JSONArray result = new JSONArray();
        result.add(construirPunto("l", bDAO.getBasica_l()));
        result.add(construirPunto("f", bDAO.getBasica_f()));
        result.add(construirPunto("k", bDAO.getBasica_k()));
        result.add(construirPunto("hs", bDAO.getBasica_hs()));
        result.add(construirPunto("d", bDAO.getBasica_d()));/*
        result.add(construirPunto("hy", bDAO.getBasica_hy()));
        result.add(construirPunto("pd", bDAO.getBasica_pd()));
        result.add(construirPunto("mf_m", bDAO.getBasica_mf_m()));
        result.add(construirPunto("mf_f", bDAO.getBasica_mf_f()));
        result.add(construirPunto("pa", bDAO.getBasica_pa()));
        result.add(construirPunto("pt", bDAO.getBasica_pt()));
        result.add(construirPunto("sc", bDAO.getBasica_sc()));
        result.add(construirPunto("ma", bDAO.getBasica_ma()));
        result.add(construirPunto("si", bDAO.getBasica_si()));
        result.add(construirPunto("anx", bDAO.getContenido_anx()));
        result.add(construirPunto("frs", bDAO.getContenido_frs()));
        result.add(construirPunto("obs", bDAO.getContenido_obs()));
        result.add(construirPunto("dep", bDAO.getContenido_dep()));
        result.add(construirPunto("hea", bDAO.getContenido_hea()));
        result.add(construirPunto("biz", bDAO.getContenido_biz()));
        result.add(construirPunto("ang", bDAO.getContenido_ang()));
        result.add(construirPunto("cyn", bDAO.getContenido_cyn()));
        result.add(construirPunto("asp", bDAO.getContenido_asp()));
        result.add(construirPunto("tpa", bDAO.getContenido_tpa()));
        result.add(construirPunto("lse", bDAO.getContenido_lse()));
        result.add(construirPunto("sod", bDAO.getContenido_sod()));
        result.add(construirPunto("fam", bDAO.getContenido_fam()));
        result.add(construirPunto("wrk", bDAO.getContenido_wrk()));
        result.add(construirPunto("trt", bDAO.getContenido_trt()));
        result.add(construirPunto("a", bDAO.getSuplementarias_a()));
        result.add(construirPunto("r", bDAO.getSuplementarias_r()));
        result.add(construirPunto("es", bDAO.getSuplementarias_es()));
        result.add(construirPunto("mac_r", bDAO.getSuplementarias_mac_r()));
        result.add(construirPunto("o_h", bDAO.getSuplementarias_o_h()));
        result.add(construirPunto("do", bDAO.getSuplementarias_do()));
        result.add(construirPunto("re", bDAO.getSuplementarias_re()));
        result.add(construirPunto("mt", bDAO.getSuplementarias_mt()));
        result.add(construirPunto("gm", bDAO.getSuplementarias_gm()));
        result.add(construirPunto("gf", bDAO.getSuplementarias_gf()));
        result.add(construirPunto("pk", bDAO.getSuplementarias_pk()));
        result.add(construirPunto("ps", bDAO.getSuplementarias_ps()));
        result.add(construirPunto("si1", bDAO.getSuplementarias_si1()));
        result.add(construirPunto("si2", bDAO.getSuplementarias_si2()));
        result.add(construirPunto("si3", bDAO.getSuplementarias_si3()));
        result.add(construirPunto("mds", bDAO.getSuplementarias_mds()));
        result.add(construirPunto("aps", bDAO.getSuplementarias_aps()));
        result.add(construirPunto("aas", bDAO.getSuplementarias_aas()));
        result.add(construirPunto("fb_back", bDAO.getAdicionales_fb_back()));
        result.add(construirPunto("f_p", bDAO.getAdicionales_f_p()));
        result.add(construirPunto("ds", bDAO.getAdicionales_ds()));
        result.add(construirPunto("ds_r", bDAO.getAdicionales_ds_r()));
        result.add(construirPunto("s", bDAO.getAdicionales_s()));
        result.add(construirPunto("sd", bDAO.getAdicionales_sd()));
        result.add(construirPunto("so", bDAO.getAdicionales_so()));
        result.add(construirPunto("vrin", bDAO.getAdicionales_vrin()));
        result.add(construirPunto("trin", bDAO.getAdicionales_trin()));*/
		return result;
	}

	private JSONObject construirPunto(String label, Integer valor) {
		return construirPunto(label, valor, 0);
	}
	
	private JSONObject construirPunto(String label, Integer valor, Integer z) {
		JSONObject result = new JSONObject();
		result.put("label", label);
		result.put("y", valor);
		result.put("z", z);
		return result;
	}
	
	public JSONArray parsearBaremosParaGraficoDeBurbujas(List<BaremoDAO> baremosFiltrados){
    	JSONArray result = new JSONArray();
    	JSONArray[] puntos = construirPuntosPorRango(baremosFiltrados);  	
    	for (int i = 0 ; i < puntos.length ; i++) {
    		JSONArray data = (JSONArray) puntos[i];
	    		if (!data.isEmpty()) {
		    	JSONObject item = new JSONObject();
				item.put("type", "bubble");
				item.put("toolTipContent", "<b>Valor:</b>{z}");
				item.put("dataPoints", data);
				result.add(item);
			}
    	}
    	// Permite que el gráfico se dibuje vacío
    	if (result.isEmpty()) {
    		result.add(new JSONObject());
    	}
    	return result;
    }

	private int[] procesarDatosPorSubindice(String sub, List<BaremoDAO> baremosFiltrados) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method getDato = BaremoDAO.class.getMethod("getBasica_"+sub);
		int[] rangos = new int[RANGOS];
		Integer valor = null;
		for (BaremoDAO row : baremosFiltrados) {
			valor = (Integer) getDato.invoke(row);
			alocarEnRango(rangos, valor);
		}
		return rangos;
	}

	private void alocarEnRango(int[] rangos, Integer valor) {
		if(isBetween(0, 10, valor)) {
			rangos[0] ++;
		} else if(isBetween(11, 20, valor)) {
			rangos[1] ++;
		} else if(isBetween(21, 30, valor)) {
			rangos[2] ++;
		} else if(isBetween(31, 40, valor)) {
			rangos[3] ++;
		} else if(isBetween(41, 50, valor)) {
			rangos[4] ++;
		} else if(isBetween(51, 60, valor)) {
			rangos[5] ++;
		} else if(isBetween(61, 70, valor)) {
			rangos[6] ++;
		} else if(isBetween(71, 80, valor)) {
			rangos[7] ++;
		} else if(isBetween(81, 90, valor)) {
			rangos[8] ++;
		} else if(isBetween(91, 100, valor)) {
			rangos[9] ++;
		}
		/*if(isBetween(0, 5, valor)) {
			rangos[0] ++;
		} else if(isBetween(0, 5, valor)) {
			rangos[1] ++;
		} else if(isBetween(6, 10, valor)) {
			rangos[2] ++;
		} else if(isBetween(11, 15, valor)) {
			rangos[3] ++;
		} else if(isBetween(16, 20, valor)) {
			rangos[4] ++;
		} else if(isBetween(21, 25, valor)) {
			rangos[5] ++;
		} else if(isBetween(26, 30, valor)) {
			rangos[6] ++;
		} else if(isBetween(31, 35, valor)) {
			rangos[7] ++;
		} else if(isBetween(36, 40, valor)) {
			rangos[8] ++;
		} else if(isBetween(41, 45, valor)) {
			rangos[9] ++;
		} else if(isBetween(46, 50, valor)) {
			rangos[10] ++;
		} else if(isBetween(51, 55, valor)) {
			rangos[11] ++;
		} else if(isBetween(56, 60, valor)) {
			rangos[12] ++;
		} else if(isBetween(61, 65, valor)) {
			rangos[13] ++;
		} else if(isBetween(66, 70, valor)) {
			rangos[14] ++;
		} else if(isBetween(71, 75, valor)) {
			rangos[15] ++;
		} else if(isBetween(76, 80, valor)) {
			rangos[16] ++;
		} else if(isBetween(81, 85, valor)) {
			rangos[17] ++;
		} else if(isBetween(86, 90, valor)) {
			rangos[18] ++;
		} else if(isBetween(91, 99, valor)) {
			rangos[19] ++;
		}*/
	}
			
	private boolean isBetween(int min, int max, int n) {
	    return max > min ? n >= min && n <= max : n > max && n < min;
	}
	
	private JSONArray[] construirPuntosPorRango(List<BaremoDAO> baremosFiltrados) {
    	JSONArray[] puntos = null;
    	try {
    		String[] subindices = new String[] {"l", "k", "f", "hs", "d"/*, "hy", "pd","mf_m", "mf_f", "pa", "pt", "sc", "ma", "si"*/};
    		HashMap<String, int[]> datosProcesadosPorSubindice = procesarListaDeSubindices(subindices, baremosFiltrados);
			puntos = new JSONArray[RANGOS];
			for (int i = 0 ; i < RANGOS ; i++) {
				JSONArray puntosPorRango = new JSONArray();
				for (String subindice : subindices) {
					int z = datosProcesadosPorSubindice.get(subindice)[i];
					if (z>0) {
						puntosPorRango.add(construirPunto(subindice, (((i+1)*10)-5), z));
					}
				}
				puntos[i] = puntosPorRango;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return puntos;
	}

	private HashMap<String, int[]> procesarListaDeSubindices(String[] strings, List<BaremoDAO> baremosFiltrados) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HashMap<String, int[]> result = new HashMap<>();
		for (String subIndice : strings) {
			result.put(subIndice, procesarDatosPorSubindice(subIndice, baremosFiltrados));
		}
		return result;
	}
}
