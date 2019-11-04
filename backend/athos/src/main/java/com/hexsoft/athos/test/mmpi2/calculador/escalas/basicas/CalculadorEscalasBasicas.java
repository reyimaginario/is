package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorEscalas;
import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorEscalasBasicas extends ACalculadorEscalas {

	private static CalculadorEscalasBasicas instance;
	private List<ACalculadorSubescalas> subescalas;
	
	private CalculadorEscalasBasicas() {
		subescalas = new ArrayList<>();
		subescalas.add(CalculadorSubescalaL.getInstance());
		subescalas.add(CalculadorSubescalaF.getInstance());
		subescalas.add(CalculadorSubescalaK.getInstance());
		subescalas.add(CalculadorSubescalaHS.getInstance());
		subescalas.add(CalculadorSubescalaD.getInstance());
		subescalas.add(CalculadorSubescalaHY.getInstance());
		subescalas.add(CalculadorSubescalaPD.getInstance());
	}
	
	public static CalculadorEscalasBasicas getInstance() {
		return instance;
	}
	
	@Override
	public JSONObject construirEscalas(JSONObject respuestasAProcesar) {
		return construirEscalasBasicas(respuestasAProcesar);
	}

	@SuppressWarnings("unchecked")
	private JSONObject construirEscalasBasicas(JSONObject respuestasAProcesar) {
		JSONObject escalasBasicas = new JSONObject();
		for (ACalculadorSubescalas calculadorSubescala : subescalas) {
			escalasBasicas.put(calculadorSubescala.getDenominadorEscala(), calculadorSubescala.getPuntajes(respuestasAProcesar));
		}
		return escalasBasicas;
	}
}
