package com.hexsoft.athos.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.hexsoft.athos.entities.RespuestaDAO;

public abstract class ATest {
	private String codigo;
	private JSONObject preguntas;
	private ICalculador calculador;
	
	public abstract JSONObject procesarRespuestas(List<RespuestaDAO> respuestas);
	public abstract File obtenerPreguntasComoFile();
	public abstract JSONObject obtenerPreguntasComoJSON() throws IOException, ParseException;
}
