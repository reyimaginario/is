package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.List;

import org.json.simple.JSONObject;

public abstract class ACalculadorEscalas {
	
	protected List<CalculadorSubescalas> subescalas;
	
	public JSONObject construirEscalas(JSONObject respuestasAProcesar) {
		JSONObject escalasBasicas = new JSONObject();
		for (CalculadorSubescalas calculadorSubescala : subescalas) {
			escalasBasicas.put(calculadorSubescala.getDenominadorEscala(), calculadorSubescala.getPuntajes(respuestasAProcesar));
		}
		return escalasBasicas;
	};
}
