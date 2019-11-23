package com.hexsoft.athos.test.mmpi2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hexsoft.athos.entities.RespuestaDAO;
import com.hexsoft.athos.test.ATest;

public class TestMMPI2 extends ATest {

	public static final String CODIGO = "MMPI2";
	private static final String PATH_PREGUNTAS = "src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\preguntas_mmpi2.json";
	private static final CalculadorMMPI2 calculador = new CalculadorMMPI2();
	
	@Override
	public JSONObject procesarRespuestas(List<RespuestaDAO> respuestas) {
		return calculador.procesarRespuestas(respuestas);
	}

	@Override
	public File obtenerPreguntasComoFile() {
		return new File(PATH_PREGUNTAS);
	}

	@Override
	public JSONObject obtenerPreguntasComoJSON() throws IOException, ParseException {
		FileReader reader = new FileReader(obtenerPreguntasComoFile());
	    JSONParser jsonParser = new JSONParser();
	    return (JSONObject) jsonParser.parse(reader);
	}
}
