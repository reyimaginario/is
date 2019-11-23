package com.hexsoft.athos.test.mmpi2.calculador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hexsoft.athos.services.TestService;
import com.hexsoft.athos.test.ConstantestServicioTest;
import com.hexsoft.athos.test.mmpi2.CalculadorMMPI2;
import com.hexsoft.athos.test.mmpi2.TestMMPI2;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasAdicionalesDeValidez;

public class tetCalcu {

	public static void main(String[] args) throws Exception {			
		JSONObject respuestasJSON = (JSONObject) readJsonSimpleDemo("src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\calculador\\respuestas.json");
		TestMMPI2 test = (TestMMPI2) TestService.getInstance().obtenerTest(ConstantestServicioTest.CODIGO_TEST_MMPI2);
		CalculadorMMPI2 calcu = new CalculadorMMPI2();
		System.out.println(calcu.construirEscalas(respuestasJSON));
    }
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
}