package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class ACalculadorEscalas {
	
	protected List<CalculadorSubescalas> subescalas;
	
	public JSONArray construirEscalas(JSONObject respuestasAProcesar) {
		JSONArray escalasBasicas = new JSONArray();
		for (CalculadorSubescalas calculadorSubescala : subescalas) {
			escalasBasicas.add(calculadorSubescala.getPuntajes(respuestasAProcesar));
		}
		return escalasBasicas;
	};
}
