package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaF extends ACalculadorSubescalas {

	private static CalculadorSubescalaF instance;
	
	private CalculadorSubescalaF() {
		inicializarConstantesMyF();
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
		getSubEscalaMasc().put(0, 36);
		getSubEscalaMasc().put(1, 39);
		getSubEscalaMasc().put(2, 42);
		getSubEscalaMasc().put(3, 45);
		getSubEscalaMasc().put(4, 48);
		getSubEscalaMasc().put(5, 51);
		getSubEscalaMasc().put(6, 55);
		getSubEscalaMasc().put(7, 58);
		getSubEscalaMasc().put(8, 62);
		getSubEscalaMasc().put(9, 64);
		getSubEscalaMasc().put(10, 67);
		getSubEscalaMasc().put(11, 71);
		getSubEscalaMasc().put(12, 73);
		getSubEscalaMasc().put(13, 76);
		getSubEscalaMasc().put(14, 79);
		getSubEscalaMasc().put(15, 82);
		getSubEscalaMasc().put(16, 85);
		getSubEscalaMasc().put(17, 89);
		getSubEscalaMasc().put(18, 92);
		getSubEscalaMasc().put(19, 95);
		getSubEscalaMasc().put(20, 98);
		getSubEscalaMasc().put(21, 101);
		getSubEscalaMasc().put(22, 104);
		getSubEscalaMasc().put(23, 107);
		getSubEscalaMasc().put(24, 110);
		getSubEscalaMasc().put(25, 113);
		getSubEscalaMasc().put(26, 116);
		getSubEscalaMasc().put(27, 119);
		getSubEscalaMasc().put(28, 120);
		
		// F Femenina
		getSubEscalaFem().put(0, 37);
		getSubEscalaFem().put(1, 41);
		getSubEscalaFem().put(2, 44);
		getSubEscalaFem().put(3, 48);
		getSubEscalaFem().put(4, 51);
		getSubEscalaFem().put(5, 55);
		getSubEscalaFem().put(6, 58);
		getSubEscalaFem().put(7, 61);
		getSubEscalaFem().put(8, 65);
		getSubEscalaFem().put(9, 68);
		getSubEscalaFem().put(10, 72);
		getSubEscalaFem().put(11, 75);
		getSubEscalaFem().put(12, 79);
		getSubEscalaFem().put(13, 82);
		getSubEscalaFem().put(14, 85);
		getSubEscalaFem().put(15, 89);
		getSubEscalaFem().put(16, 92);
		getSubEscalaFem().put(17, 96);
		getSubEscalaFem().put(18, 99);
		getSubEscalaFem().put(19, 100);
		getSubEscalaFem().put(20, 106);
		getSubEscalaFem().put(21, 109);
		getSubEscalaFem().put(22, 113);
		getSubEscalaFem().put(23, 116);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.F_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.F_ANSWERS_F;
	}
	
	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_F;
	}
}
