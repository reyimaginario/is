package com.hexsoft.athos.test.mmpi2.calculador;

import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONObject;

public class CalculadorSubescalaVRIN extends CalculadorSubescalas {
	
	private ArrayList<String[]> respuestasAChequear;
	
	public CalculadorSubescalaVRIN(String denominadorEscala, Map<Integer, Integer> subEscalaMasc, Map<Integer, Integer> subEscalaFem) {
		super(denominadorEscala, new Integer[]{}, new Integer[]{}, subEscalaMasc, subEscalaFem);
		inicializarRespuestasAChequear();
	}
	
	private void inicializarRespuestasAChequear() {
		respuestasAChequear = new ArrayList<>();
		respuestasAChequear.add(new String[]{"3", "True", "39", "True"});
		respuestasAChequear.add(new String[]{"6", "True", "90", "False"});
		respuestasAChequear.add(new String[]{"6", "False", "90", "True"});
		respuestasAChequear.add(new String[]{"9", "False", "56", "False"});
		respuestasAChequear.add(new String[]{"28", "True", "59", "False"});
		respuestasAChequear.add(new String[]{"31", "True", "299", "False"});
		respuestasAChequear.add(new String[]{"32", "False", "316", "True"});
		respuestasAChequear.add(new String[]{"40", "True", "176", "True"});
		respuestasAChequear.add(new String[]{"46", "True", "265", "False"});
		respuestasAChequear.add(new String[]{"48", "True", "184", "True"});
		respuestasAChequear.add(new String[]{"49", "True", "280", "False"});
		respuestasAChequear.add(new String[]{"73", "True", "377", "False"});
		respuestasAChequear.add(new String[]{"81", "True", "284", "False"});
		respuestasAChequear.add(new String[]{"81", "False", "284", "True"});
		respuestasAChequear.add(new String[]{"83", "True", "288", "True"});
		respuestasAChequear.add(new String[]{"84", "True", "105", "False"});
		respuestasAChequear.add(new String[]{"86", "True", "359", "False"});
		respuestasAChequear.add(new String[]{"95", "False", "388", "True"});
		respuestasAChequear.add(new String[]{"99", "False", "138", "True"});
		respuestasAChequear.add(new String[]{"103", "True", "344", "False"});
		respuestasAChequear.add(new String[]{"110", "True", "374", "False"});
		respuestasAChequear.add(new String[]{"110", "False", "374", "True"});
		respuestasAChequear.add(new String[]{"116", "True", "430", "False"});
		respuestasAChequear.add(new String[]{"125", "True", "195", "True"});
		respuestasAChequear.add(new String[]{"125", "False", "195", "False"});
		respuestasAChequear.add(new String[]{"135", "False", "482", "True"});
		respuestasAChequear.add(new String[]{"136", "True", "507", "False"});
		respuestasAChequear.add(new String[]{"136", "False", "507", "True"});
		respuestasAChequear.add(new String[]{"152", "False", "464", "False"});
		respuestasAChequear.add(new String[]{"161", "True", "185", "False"});
		respuestasAChequear.add(new String[]{"161", "False", "185", "True"});
		respuestasAChequear.add(new String[]{"165", "False", "565", "False"});
		respuestasAChequear.add(new String[]{"166", "True", "268", "False"});
		respuestasAChequear.add(new String[]{"166", "False", "268", "True"});
		respuestasAChequear.add(new String[]{"167", "True", "243", "False"});
		respuestasAChequear.add(new String[]{"196", "False", "415", "True"});
		respuestasAChequear.add(new String[]{"199", "True", "467", "False"});
		respuestasAChequear.add(new String[]{"199", "False", "467", "True"});
		respuestasAChequear.add(new String[]{"226", "True", "267", "False"});
		respuestasAChequear.add(new String[]{"259", "False", "333", "True"});
		respuestasAChequear.add(new String[]{"262", "False", "275", "False"});
		respuestasAChequear.add(new String[]{"290", "True", "556", "False"});
		respuestasAChequear.add(new String[]{"290", "False", "556", "True"});
		respuestasAChequear.add(new String[]{"339", "False", "394", "True"});
		respuestasAChequear.add(new String[]{"349", "True", "515", "False"});
		respuestasAChequear.add(new String[]{"349", "False", "515", "True"});
		respuestasAChequear.add(new String[]{"350", "False", "521", "True"});
		respuestasAChequear.add(new String[]{"353", "True", "370", "False"});
		respuestasAChequear.add(new String[]{"353", "False", "370", "True"});
		respuestasAChequear.add(new String[]{"364", "False", "554", "True"});
		respuestasAChequear.add(new String[]{"369", "False", "421", "True"});
		respuestasAChequear.add(new String[]{"372", "True", "405", "False"});
		respuestasAChequear.add(new String[]{"372", "False", "405", "True"});
		respuestasAChequear.add(new String[]{"380", "True", "562", "False"});
		respuestasAChequear.add(new String[]{"395", "True", "435", "False"});
		respuestasAChequear.add(new String[]{"395", "False", "435", "True"});
		respuestasAChequear.add(new String[]{"396", "True", "403", "False"});
		respuestasAChequear.add(new String[]{"396", "False", "403", "True"});
		respuestasAChequear.add(new String[]{"411", "False", "485", "True"});
		respuestasAChequear.add(new String[]{"411", "True", "485", "False"});
		respuestasAChequear.add(new String[]{"472", "True", "533", "False"});
		respuestasAChequear.add(new String[]{"472", "False", "533", "True"});
		respuestasAChequear.add(new String[]{"491", "True", "509", "False"});
		respuestasAChequear.add(new String[]{"506", "True", "520", "False"});
		respuestasAChequear.add(new String[]{"506", "False", "520", "True"});
		respuestasAChequear.add(new String[]{"513", "True", "542", "False"});
		respuestasAChequear.add(new String[]{"167", "False", "243", "True"});
	}
	
	@Override
	public Integer getPuntajeBruto(JSONObject respuestas) {
		Integer pb = 0;
		for (String[] parAChequear : respuestasAChequear) {
			String respuesta1 = parAChequear[0];
			String valor1 = parAChequear[1];
			String respuesta2 = parAChequear[2];
			String valor2 = parAChequear[3];
			if (respuestas.get(respuesta1).equals(valor1) && respuestas.get(respuesta2).equals(valor2)) {
				pb = (pb + 1);
			}
		}
		return pb;
	}
}
