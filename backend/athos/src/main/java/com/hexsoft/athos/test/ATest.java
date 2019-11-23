package com.hexsoft.athos.test;

import com.hexsoft.athos.entities.RespuestaDAO;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class ATest {
	private String codigo;
	private JSONObject preguntas;
	private ICalculador calculador;
	
	public abstract JSONObject procesarRespuestas(List<RespuestaDAO> listaRespuestasDAO);
	public abstract File obtenerPreguntasComoFile();
	public abstract JSONObject obtenerPreguntasComoJSON() throws IOException, ParseException;
}
