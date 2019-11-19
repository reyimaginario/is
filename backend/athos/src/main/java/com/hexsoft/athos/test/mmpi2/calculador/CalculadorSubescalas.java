package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaBasica;

public class CalculadorSubescalas {
	
	private String denominadorEscala;
	private Integer[] preguntasAChequearPorVerdadero;
	private Integer[] preguntasAChequearPorFalso;
	private Map<Integer, Integer> subEscalaMasc = new HashMap<>();
	private Map<Integer, Integer> subEscalaFem = new HashMap<>();
	
	public CalculadorSubescalas(String denominadorEscala, Integer[] preguntasAChequearPorVerdadero, Integer[] preguntasAChequearPorFalso, Map<Integer, Integer> subEscalaMasc, Map<Integer, Integer> subEscalaFem){
		this(preguntasAChequearPorVerdadero, preguntasAChequearPorFalso, subEscalaMasc, subEscalaFem);
		this.denominadorEscala = denominadorEscala;
	}
	
	public CalculadorSubescalas(Integer[] preguntasAChequearPorVerdadero, Integer[] preguntasAChequearPorFalso, Map<Integer, Integer> subEscalaMasc, Map<Integer, Integer> subEscalaFem){
		this.preguntasAChequearPorVerdadero = preguntasAChequearPorVerdadero;
		this.preguntasAChequearPorFalso = preguntasAChequearPorFalso;
		this.subEscalaMasc = subEscalaMasc;
		this.subEscalaFem = subEscalaFem;
	}
	
	// Calcula los puntajes basicos y los T para sujetos masculinos y femeninos
	@SuppressWarnings("unchecked")
	public JSONObject getPuntajes(JSONObject respuestas) {
		JSONObject resultado = new JSONObject();
		Integer pb = getPuntajeBruto(respuestas);
		Integer ptm = subEscalaMasc.get(pb);
		Integer ptf = subEscalaFem.get(pb);
		
		resultado.put(ConstantesEscalaBasica.PB, pb);
		resultado.put(ConstantesEscalaBasica.PTM, ptm);
		resultado.put(ConstantesEscalaBasica.PTF, ptf);
		
		return resultado;
	}

	public Integer getPuntajeBruto(JSONObject respuestas) {
		Integer pb = new Integer(0);
		
		// Suma 1 por cada pregunta en la lista si se encuentra en Verdadero
		for (Integer answerNbr : preguntasAChequearPorVerdadero){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("True"))? pb+1 : pb;
		}

		// Suma 1 por cada pregunta en la lista si se encuentra en Falso
		for (Integer answerNbr : preguntasAChequearPorFalso){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("False"))? pb+1 : pb;
		}
		
		return pb;
	}
	
	public void setSubEscalaMasc(Map<Integer, Integer> subEscalaMasc) {
		this.subEscalaMasc = subEscalaMasc;
	}
	
	public void setSubEscalaFem(Map<Integer, Integer> subEscalaFem) {
		this.subEscalaFem = subEscalaFem;
	}
	
	public String getDenominadorEscala() {
		return denominadorEscala;
	}
	
}
