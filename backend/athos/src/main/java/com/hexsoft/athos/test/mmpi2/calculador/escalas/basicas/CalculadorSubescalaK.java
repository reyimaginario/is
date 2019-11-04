package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaK extends ACalculadorSubescalas {
	
	private static CalculadorSubescalaK instance;
	
	private CalculadorSubescalaK() {
		inicializarConstantesMyF();
	}
	
	public static CalculadorSubescalaK getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaK();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		
		// K Masculina
		getSubEscalaMasc().put(6, 30);
		getSubEscalaMasc().put(7, 33);
		getSubEscalaMasc().put(8, 35);
		getSubEscalaMasc().put(9, 37);
		getSubEscalaMasc().put(10, 39);
		getSubEscalaMasc().put(11, 41);
		getSubEscalaMasc().put(12, 43);
		getSubEscalaMasc().put(13, 45);
		getSubEscalaMasc().put(14, 47);
		getSubEscalaMasc().put(15, 49);
		getSubEscalaMasc().put(16, 51);
		getSubEscalaMasc().put(17, 54);
		getSubEscalaMasc().put(18, 56);
		getSubEscalaMasc().put(19, 58);
		getSubEscalaMasc().put(20, 60);
		getSubEscalaMasc().put(21, 62);
		getSubEscalaMasc().put(22, 64);
		getSubEscalaMasc().put(23, 66);
		getSubEscalaMasc().put(24, 68);
		getSubEscalaMasc().put(25, 70);
		getSubEscalaMasc().put(26, 72);
		getSubEscalaMasc().put(27, 75);
		getSubEscalaMasc().put(28, 77);
		getSubEscalaMasc().put(29, 79);
		getSubEscalaMasc().put(30, 81);
		
		// K Femenina
		getSubEscalaFem().put(30,83);
		getSubEscalaFem().put(29,81);
		getSubEscalaFem().put(28,78);
		getSubEscalaFem().put(27,76);
		getSubEscalaFem().put(26,74);
		getSubEscalaFem().put(25,72);
		getSubEscalaFem().put(24,70);
		getSubEscalaFem().put(23,67);
		getSubEscalaFem().put(22,65);
		getSubEscalaFem().put(21,63);
		getSubEscalaFem().put(20,61);
		getSubEscalaFem().put(19,59);
		getSubEscalaFem().put(18,56);
		getSubEscalaFem().put(17,54);
		getSubEscalaFem().put(16,52);
		getSubEscalaFem().put(15,50);
		getSubEscalaFem().put(14,48);
		getSubEscalaFem().put(13,46);
		getSubEscalaFem().put(12,43);
		getSubEscalaFem().put(11,41);
		getSubEscalaFem().put(10,39);
		getSubEscalaFem().put(9,37);
		getSubEscalaFem().put(8,35);
		getSubEscalaFem().put(7,32);
		getSubEscalaFem().put(6,30);
	}
	
	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.K_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.K_ANSWERS_F;
	}
	
	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_K;
	}
}
