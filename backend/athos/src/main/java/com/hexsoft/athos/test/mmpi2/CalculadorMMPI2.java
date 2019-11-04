package com.hexsoft.athos.test.mmpi2;

import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.entities.Respuesta;
import com.hexsoft.athos.test.ICalculador;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasBasicas;

public class CalculadorMMPI2 implements ICalculador {
	
	@Override
	public String procesarRespuestas(List<Respuesta> respuestas) {
		JSONObject respestasAProcesar = respuestas.get(0).obterneRespuestasComoJSON();
		construirEscalas(respestasAProcesar);

		return null;
	}	
	
	public void construirEscalas(JSONObject respuestasAProcesar) {
		CalculadorEscalasBasicas.getInstance().construirEscalas(respuestasAProcesar);
		// Contenido
		// Suplementarias
		// Adicionales de Validez
		// Harris-lingoes
		// Wiener Harmon
	}
}
