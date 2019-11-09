package com.hexsoft.athos.test.mmpi2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hexsoft.athos.entities.Respuesta;
import com.hexsoft.athos.test.ATest;

public class TestMMPI2 extends ATest {

	private static final String PATH_PREGUNTAS = "src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\preguntas_mmpi2.json";
	
	@Override
	public void procesarRespuestas(List<Respuesta> respuestas) {
		// TODO Auto-generated method stub

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
