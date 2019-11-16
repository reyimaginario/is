package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.Map;

import org.json.simple.JSONObject;

public class CalculadorSubescalasConDesvio extends CalculadorSubescalas {

	private double desvio;
	private CalculadorSubescalas referencia;
	
	public CalculadorSubescalasConDesvio(String denominadorEscala, Integer[] preguntasAChequearPorVerdadero,
			Integer[] preguntasAChequearPorFalso, Map<Integer, Integer> subEscalaMasc,
			Map<Integer, Integer> subEscalaFem, double desvio, CalculadorSubescalas referencia) {
		super(denominadorEscala, preguntasAChequearPorVerdadero, preguntasAChequearPorFalso, subEscalaMasc, subEscalaFem);
		this.desvio = desvio;
		this.referencia = referencia;
	}

	@Override
	public Integer getPuntajeBruto(JSONObject respuestas) {
		return (super.getPuntajeBruto(respuestas) + calcularDesvio(respuestas));
	}
	
	private int calcularDesvio(JSONObject respuestas) {		
		return (int) Math.ceil(referencia.getPuntajeBruto(respuestas) * desvio);
	}
}
