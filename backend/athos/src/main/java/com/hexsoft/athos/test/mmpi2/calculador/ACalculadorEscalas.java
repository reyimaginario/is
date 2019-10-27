package com.hexsoft.athos.test.mmpi2.calculador;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class ACalculadorEscalas {
	abstract public JSONObject construirEscalas(JSONObject respuestasAProcesar) throws JSONException;
}
