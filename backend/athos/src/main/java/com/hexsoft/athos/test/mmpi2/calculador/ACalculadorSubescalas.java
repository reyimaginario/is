package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.hexsoft.athos.test.mmpi2.ConstantesMMPI;

public abstract class ACalculadorSubescalas {
	
	private Map<Integer, Integer> subEscalaMasc = new HashMap<>();
	private Map<Integer, Integer> subEscalaFem = new HashMap<>();
	
	
	abstract protected void inicializarConstantesMyF();
	
	public JSONObject getPuntaje(Integer[] preguntasAChequearPorV, Integer[] preguntasAChequearPorF, JSONObject respuestas) {
		inicializarConstantesMyF();
		return getPuntaje(preguntasAChequearPorV, preguntasAChequearPorF, respuestas);
	}
	
	protected Map<Integer, Integer> getSubEscalaMasc(){
		return subEscalaMasc;
	};
	
	protected Map<Integer, Integer> getSubEscalaFem(){
		return subEscalaFem;
	};
	
	// Calcula los puntajes basicos y los T para sujetos masculinos y femeninos
	private JSONObject getPuntajeBruto(Integer[] preguntasAChequearPorV, Integer[] preguntasAChequearPorF, JSONObject respuestas) throws JSONException {
		JSONObject resultado = new JSONObject();
		Integer pb = new Integer(0);
		
		// Suma 1 por cada pregunta en la lista si se encuetnra en Verdadero
		for (Integer answerNbr : preguntasAChequearPorV){
			Boolean ans = (Boolean) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans)? pb++ : pb;
		}

		// Suma 1 por cada pregunta en la lista si se encuetnra en Falso
		for (Integer answerNbr : preguntasAChequearPorF){
			Boolean ans = (Boolean) respuestas.get(answerNbr.toString());
			pb = (ans != null && !ans)? pb++ : pb;
		}
				
		Integer ptm = subEscalaMasc.get(pb);
		Integer ptf = subEscalaFem.get(pb);
		
		resultado.put(ConstantesMMPI.PB, pb)
			.put(ConstantesMMPI.PTM, ptm)
			.put(ConstantesMMPI.PTF, ptf);
		
		return resultado;
	}
}
