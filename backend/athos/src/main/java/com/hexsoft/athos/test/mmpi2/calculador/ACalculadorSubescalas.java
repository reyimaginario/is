package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.ConstantesEscalasBasicas;

public abstract class ACalculadorSubescalas {
	
	private Map<Integer, Integer> subEscalaMasc = new HashMap<>();
	private Map<Integer, Integer> subEscalaFem = new HashMap<>();
	
	
	abstract protected void inicializarConstantesMyF();
	
	protected Map<Integer, Integer> getSubEscalaMasc(){
		return subEscalaMasc;
	};
	
	protected Map<Integer, Integer> getSubEscalaFem(){
		return subEscalaFem;
	};
	
	// Calcula los puntajes basicos y los T para sujetos masculinos y femeninos
	@SuppressWarnings("unchecked")
	public JSONObject getPuntajes(JSONObject respuestas) {
		JSONObject resultado = new JSONObject();
		Integer pb = getPuntajeBruto(respuestas);
		Integer ptm = subEscalaMasc.get(pb);
		Integer ptf = subEscalaFem.get(pb);
		
		resultado.put(ConstantesEscalasBasicas.PB, pb);
		resultado.put(ConstantesEscalasBasicas.PTM, ptm);
		resultado.put(ConstantesEscalasBasicas.PTF, ptf);
		
		return resultado;
	}

	public Integer getPuntajeBruto(JSONObject respuestas) {
		Integer pb = new Integer(0);
		
		// Suma 1 por cada pregunta en la lista si se encuentra en Verdadero
		for (Integer answerNbr : getPreguntasAChequearPorVerdadero()){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("True"))? pb+1 : pb;
		}

		// Suma 1 por cada pregunta en la lista si se encuentra en Falso
		for (Integer answerNbr : getpreguntasAChequearPorFalso()){
			String ans = (String) respuestas.get(answerNbr.toString());
			pb = (ans != null && ans.equalsIgnoreCase("False"))? pb+1 : pb;
		}
				
		pb = pb + geDesvio(respuestas);
		
		return pb;
	}

	protected abstract Integer[] getPreguntasAChequearPorVerdadero();
	
	protected abstract Integer[] getpreguntasAChequearPorFalso();
	
	/***
	 * Este método debe ser sobreescrito por aquellas subescalas que tengan un desvío,
	 * de manera que calculen y regresen el valor de dicho desvío.
	 * @return
	 * 	El desvío calculado o 0 si no se sobreescribe.
	 */
	protected Integer geDesvio(JSONObject respuestas) {
		return 0;
	}
	
	public abstract String getDenominadorEscala();
}
