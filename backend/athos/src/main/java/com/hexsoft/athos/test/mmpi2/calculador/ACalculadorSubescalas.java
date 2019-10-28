package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.ConstantesMMPI;

public abstract class ACalculadorSubescalas {
	
	private Map<Integer, Integer> subEscalaMasc = new HashMap<>();
	private Map<Integer, Integer> subEscalaFem = new HashMap<>();
	
	
	abstract protected void inicializarConstantesMyF();
	
	public JSONObject getPuntaje(Integer[] preguntasAChequearPorV, Integer[] preguntasAChequearPorF, JSONObject respuestas) {
		inicializarConstantesMyF();
		return getPuntajeBruto(preguntasAChequearPorV, preguntasAChequearPorF, respuestas);
	}
	
	protected Map<Integer, Integer> getSubEscalaMasc(){
		return subEscalaMasc;
	};
	
	protected Map<Integer, Integer> getSubEscalaFem(){
		return subEscalaFem;
	};
	
	// Calcula los puntajes basicos y los T para sujetos masculinos y femeninos
	@SuppressWarnings("unchecked")
	private JSONObject getPuntajeBruto(Integer[] preguntasAChequearPorV, Integer[] preguntasAChequearPorF, JSONObject respuestas) {
		JSONObject resultado = new JSONObject();
		Integer pb = new Integer(0);
		
		// Suma 1 por cada pregunta en la lista si se encuetnra en Verdadero
		for (Integer answerNbr : preguntasAChequearPorV){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("True"))? pb+1 : pb;
		}

		// Suma 1 por cada pregunta en la lista si se encuetnra en Falso
		for (Integer answerNbr : preguntasAChequearPorF){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("False"))? pb+1 : pb;
		}
				
		Integer ptm = subEscalaMasc.get(pb);
		Integer ptf = subEscalaFem.get(pb);
		
		resultado.put(ConstantesMMPI.PB, pb);
		resultado.put(ConstantesMMPI.PTM, ptm);
		resultado.put(ConstantesMMPI.PTF, ptf);
		
		return resultado;
	}
}
