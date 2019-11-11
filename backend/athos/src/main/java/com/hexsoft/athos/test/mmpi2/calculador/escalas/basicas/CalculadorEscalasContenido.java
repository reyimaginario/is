package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorEscalas;
import com.hexsoft.athos.test.mmpi2.calculador.CalculadorSubescalas;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaContenido;

public class CalculadorEscalasContenido extends ACalculadorEscalas{

	private static CalculadorEscalasContenido instance;
	private List<CalculadorSubescalas> subescalas;
	
	private CalculadorEscalasContenido() {
		subescalas = new ArrayList<>();
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_ANX, ConstantesEscalaContenido.ANX_RESPUESTAS_T, ConstantesEscalaContenido.ANX_RESPUESTAS_F, ConstantesEscalaContenido.ANX_MASCULINA, ConstantesEscalaContenido.ANX_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_FRS, ConstantesEscalaContenido.FRS_RESPUESTAS_T, ConstantesEscalaContenido.FRS_RESPUESTAS_F, ConstantesEscalaContenido.FRS_MASCULINA, ConstantesEscalaContenido.FRS_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_OBS, ConstantesEscalaContenido.OBS_RESPUESTAS_T, ConstantesEscalaContenido.OBS_RESPUESTAS_F, ConstantesEscalaContenido.OBS_MASCULINA, ConstantesEscalaContenido.OBS_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_DEP, ConstantesEscalaContenido.DEP_RESPUESTAS_T, ConstantesEscalaContenido.DEP_RESPUESTAS_F, ConstantesEscalaContenido.DEP_MASCULINA, ConstantesEscalaContenido.DEP_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_HEA, ConstantesEscalaContenido.HEA_RESPUESTAS_T, ConstantesEscalaContenido.HEA_RESPUESTAS_F, ConstantesEscalaContenido.HEA_MASCULINA, ConstantesEscalaContenido.HEA_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_BIZ, ConstantesEscalaContenido.BIZ_RESPUESTAS_T, ConstantesEscalaContenido.BIZ_RESPUESTAS_F, ConstantesEscalaContenido.BIZ_MASCULINA, ConstantesEscalaContenido.BIZ_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_ANG, ConstantesEscalaContenido.ANG_RESPUESTAS_T, ConstantesEscalaContenido.ANG_RESPUESTAS_F, ConstantesEscalaContenido.ANG_MASCULINA, ConstantesEscalaContenido.ANG_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_CYN, ConstantesEscalaContenido.CYN_RESPUESTAS_T, ConstantesEscalaContenido.CYN_RESPUESTAS_F, ConstantesEscalaContenido.CYN_MASCULINA, ConstantesEscalaContenido.CYN_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_ASP, ConstantesEscalaContenido.ASP_RESPUESTAS_T, ConstantesEscalaContenido.ASP_RESPUESTAS_F, ConstantesEscalaContenido.ASP_MASCULINA, ConstantesEscalaContenido.ASP_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_TPA, ConstantesEscalaContenido.TPA_RESPUESTAS_T, ConstantesEscalaContenido.TPA_RESPUESTAS_F, ConstantesEscalaContenido.TPA_MASCULINA, ConstantesEscalaContenido.TPA_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_LSE, ConstantesEscalaContenido.LSE_RESPUESTAS_T, ConstantesEscalaContenido.LSE_RESPUESTAS_F, ConstantesEscalaContenido.LSE_MASCULINA, ConstantesEscalaContenido.LSE_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_SOD, ConstantesEscalaContenido.SOD_RESPUESTAS_T, ConstantesEscalaContenido.SOD_RESPUESTAS_F, ConstantesEscalaContenido.SOD_MASCULINA, ConstantesEscalaContenido.SOD_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_FAM, ConstantesEscalaContenido.FAM_RESPUESTAS_T, ConstantesEscalaContenido.FAM_RESPUESTAS_F, ConstantesEscalaContenido.FAM_MASCULINA, ConstantesEscalaContenido.FAM_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_WRK, ConstantesEscalaContenido.WRK_RESPUESTAS_T, ConstantesEscalaContenido.WRK_RESPUESTAS_F, ConstantesEscalaContenido.WRK_MASCULINA, ConstantesEscalaContenido.WRK_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaContenido.SUBESCALA_TRT, ConstantesEscalaContenido.TRT_RESPUESTAS_T, ConstantesEscalaContenido.TRT_RESPUESTAS_F, ConstantesEscalaContenido.TRT_MASCULINA, ConstantesEscalaContenido.TRT_FEMENINA));
		
	}

	public static CalculadorEscalasContenido getInstance() {
		if (instance == null) {
			instance = new CalculadorEscalasContenido();
		}
		return instance;
	}
}
