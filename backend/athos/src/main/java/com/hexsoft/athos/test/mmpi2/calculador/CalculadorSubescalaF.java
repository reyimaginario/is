package com.hexsoft.athos.test.mmpi2.calculador;

public class CalculadorSubescalaF extends ACalculadorSubescalas {

	private static CalculadorSubescalaF instance;
	
	private CalculadorSubescalaF() {
		// Do something
	}
	
	public static ACalculadorSubescalas getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaF();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		
		// F Masculina
		getSubEscalaMasc();
		
		// F Femenina
		getSubEscalaFem();
	}
}
