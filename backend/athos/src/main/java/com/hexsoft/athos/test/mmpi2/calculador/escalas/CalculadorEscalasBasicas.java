package com.hexsoft.athos.test.mmpi2.calculador.escalas;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorEscalas;
import com.hexsoft.athos.test.mmpi2.calculador.CalculadorSubescalas;
import com.hexsoft.athos.test.mmpi2.calculador.CalculadorSubescalasConDesvio;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaBasica;

public class CalculadorEscalasBasicas extends ACalculadorEscalas {

	private static CalculadorEscalasBasicas instance;

	private CalculadorEscalasBasicas() {
		subescalas = new ArrayList<>();
		CalculadorSubescalas calculadorSubescalaK = new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_K, ConstantesEscalaBasica.K_RESPUESTAS_T, ConstantesEscalaBasica.K_RESPUESTAS_F, ConstantesEscalaBasica.K_MASCULINA, ConstantesEscalaBasica.K_FEMENINA);
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_L, ConstantesEscalaBasica.L_RESPUESTAS_T, ConstantesEscalaBasica.L_RESPUESTAS_F, ConstantesEscalaBasica.L_MASCULINA, ConstantesEscalaBasica.L_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_F, ConstantesEscalaBasica.F_RESPUESTAS_T, ConstantesEscalaBasica.F_RESPUESTAS_F, ConstantesEscalaBasica.F_MASCULINA, ConstantesEscalaBasica.F_FEMENINA));
		subescalas.add(calculadorSubescalaK);
		subescalas.add(new CalculadorSubescalasConDesvio(ConstantesEscalaBasica.SUBESCALA_HS, ConstantesEscalaBasica.HS_RESPUESTAS_T, ConstantesEscalaBasica.HS_RESPUESTAS_F, ConstantesEscalaBasica.HS_MASCULINA, ConstantesEscalaBasica.HS_FEMENINA, 0.5, calculadorSubescalaK));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_D, ConstantesEscalaBasica.D_RESPUESTAS_T, ConstantesEscalaBasica.D_RESPUESTAS_F, ConstantesEscalaBasica.D_MASCULINA, ConstantesEscalaBasica.D_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_HY, ConstantesEscalaBasica.HY_RESPUESTAS_T, ConstantesEscalaBasica.HY_RESPUESTAS_F, ConstantesEscalaBasica.HY_MASCULINA, ConstantesEscalaBasica.HY_FEMENINA));
		subescalas.add(new CalculadorSubescalasConDesvio(ConstantesEscalaBasica.SUBESCALA_PD, ConstantesEscalaBasica.PD_RESPUESTAS_T, ConstantesEscalaBasica.PD_RESPUESTAS_F, ConstantesEscalaBasica.PD_MASCULINA, ConstantesEscalaBasica.PD_FEMENINA, 0.4, calculadorSubescalaK));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_MF_M, ConstantesEscalaBasica.MF_M_RESPUESTAS_T, ConstantesEscalaBasica.MF_M_RESPUESTAS_F, ConstantesEscalaBasica.MF_M_MASCULINA, ConstantesEscalaBasica.MF_M_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_MF_F, ConstantesEscalaBasica.MF_F_RESPUESTAS_T, ConstantesEscalaBasica.MF_F_RESPUESTAS_F, ConstantesEscalaBasica.MF_F_MASCULINA, ConstantesEscalaBasica.MF_F_FEMENINA));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_PA, ConstantesEscalaBasica.PA_RESPUESTAS_T, ConstantesEscalaBasica.PA_RESPUESTAS_F, ConstantesEscalaBasica.PA_MASCULINA, ConstantesEscalaBasica.PA_FEMENINA));
		subescalas.add(new CalculadorSubescalasConDesvio(ConstantesEscalaBasica.SUBESCALA_PT, ConstantesEscalaBasica.PT_RESPUESTAS_T, ConstantesEscalaBasica.PT_RESPUESTAS_F, ConstantesEscalaBasica.PT_MASCULINA, ConstantesEscalaBasica.PT_FEMENINA, 1.0, calculadorSubescalaK));
		subescalas.add(new CalculadorSubescalasConDesvio(ConstantesEscalaBasica.SUBESCALA_SC, ConstantesEscalaBasica.SC_RESPUESTAS_T, ConstantesEscalaBasica.SC_RESPUESTAS_F, ConstantesEscalaBasica.SC_MASCULINA, ConstantesEscalaBasica.SC_FEMENINA, 1.0, calculadorSubescalaK));
		subescalas.add(new CalculadorSubescalasConDesvio(ConstantesEscalaBasica.SUBESCALA_MA, ConstantesEscalaBasica.MA_RESPUESTAS_T, ConstantesEscalaBasica.MA_RESPUESTAS_F, ConstantesEscalaBasica.MA_MASCULINA, ConstantesEscalaBasica.MA_FEMENINA, 0.2, calculadorSubescalaK));
		subescalas.add(new CalculadorSubescalas(ConstantesEscalaBasica.SUBESCALA_SI, ConstantesEscalaBasica.SI_RESPUESTAS_T, ConstantesEscalaBasica.SI_RESPUESTAS_F, ConstantesEscalaBasica.SI_MASCULINA, ConstantesEscalaBasica.SI_FEMENINA));
	}
	
	public static CalculadorEscalasBasicas getInstance() {
		if (instance == null) {
			instance = new CalculadorEscalasBasicas();
		}
		return instance;
	}
}
