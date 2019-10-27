package com.hexsoft.athos.test.mmpi2;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.hexsoft.athos.entities.Respuesta;
import com.hexsoft.athos.test.ICalculador;
import com.hexsoft.athos.test.mmpi2.calculador.CalculadorEscalasBasicas;

public class CalculadorMMPI2 implements ICalculador {
	
	@Override
	public String procesarRespuestas(List<Respuesta> respuestas) {
		JSONObject respestasAProcesar = respuestas.get(0).obterneRespuestasComoJSON();
		try {
			construirEscalas(respestasAProcesar);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public void construirEscalas(JSONObject respuestasAProcesar) throws JSONException {
		CalculadorEscalasBasicas.getInstance().construirEscalas(respuestasAProcesar);
		// Contenido
		// Suplementarias
		// Adicionales de Validez
		// Harris-lingoes
		// Wiener Harmon
	}
}
