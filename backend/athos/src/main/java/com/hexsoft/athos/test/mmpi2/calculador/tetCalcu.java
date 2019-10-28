package com.hexsoft.athos.test.mmpi2.calculador;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hexsoft.athos.test.mmpi2.ConstantesMMPI;

public class tetCalcu {

	public static void main(String[] args) throws Exception {
		JSONObject respuestasJSON = (JSONObject) readJsonSimpleDemo("G:\\Mis Documentos\\ORT Analista de Sistemas\\3° 2°\\Integración de Sistemas\\is\\backend\\athos\\src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\calculador\\respuestas.json");
		JSONObject puntajesL = CalculadorSubescalaL.getInstance().getPuntaje(ConstantesMMPI.L_ANSWERS_T, ConstantesMMPI.L_ANSWERS_F, respuestasJSON);
		System.out.println(puntajesL);
    }
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
}