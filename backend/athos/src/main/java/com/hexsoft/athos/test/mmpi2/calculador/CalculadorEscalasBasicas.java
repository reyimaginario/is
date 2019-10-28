package com.hexsoft.athos.test.mmpi2.calculador;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.ConstantesMMPI;

public class CalculadorEscalasBasicas extends ACalculadorEscalas {

	private static CalculadorEscalasBasicas instance;
	
	private CalculadorEscalasBasicas() {
		
	}
	
	public static CalculadorEscalasBasicas getInstance() {
		return instance;
	}
	
	@Override
	public JSONObject construirEscalas(JSONObject respuestasAProcesar) {
		return construirEscalasBasicas(respuestasAProcesar);
	}

	private JSONObject construirEscalasBasicas(JSONObject respuestasAProcesar) {
		JSONObject escalasBasicas = new JSONObject();
		escalasBasicas.put(ConstantesMMPI.SUBESCALA_L, getValoresL(respuestasAProcesar));
		escalasBasicas.put(ConstantesMMPI.SUBESCALA_F, getValoresF(respuestasAProcesar));
		getKscore();
		getHSscore();
		getDscore();
		getHYscore();
		getPDscore();
		getMFFscore();
		getMFMscore();
		getPAscore();
		getPTscore();
		getSCscore();
		getMAscore();
		getSIscore();
		return escalasBasicas;
	}

	private void getSIscore() {
				
	}

	private void getMAscore() {
		// TODO Auto-generated method stub
		
	}

	private void getSCscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPTscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPAscore() {
		// TODO Auto-generated method stub
		
	}

	private void getMFMscore() {
		// TODO Auto-generated method stub
		
	}

	private void getMFFscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPDscore() {
		// K*.04
		
	}

	private void getHYscore() {
		// TODO Auto-generated method stub
		
	}

	private void getDscore() {
		// TODO Auto-generated method stub
		
	}

	private void getHSscore() {
		// K*0.5
		
	}

	private void getKscore() {
		// TODO Auto-generated method stub
		
	}

	private JSONObject getValoresF(JSONObject respuestas) {
		return CalculadorSubescalaL.getInstance().getPuntaje(ConstantesMMPI.F_ANSWERS_T, ConstantesMMPI.F_ANSWERS_F, respuestas);
	}

	private JSONObject getValoresL(JSONObject respuestas) {
		return CalculadorSubescalaL.getInstance().getPuntaje(ConstantesMMPI.L_ANSWERS_T, ConstantesMMPI.L_ANSWERS_F, respuestas);
	}
}
