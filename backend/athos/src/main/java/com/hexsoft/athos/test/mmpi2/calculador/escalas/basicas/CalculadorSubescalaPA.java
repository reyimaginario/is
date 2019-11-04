package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaPA extends ACalculadorSubescalas {

	private static CalculadorSubescalaPA instance;

	private CalculadorSubescalaPA() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaPA getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaPA();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// PA Masculino
		getSubEscalaMasc().put(30,120);
		getSubEscalaMasc().put(29,119);
		getSubEscalaMasc().put(28,116);
		getSubEscalaMasc().put(27,112);
		getSubEscalaMasc().put(26,108);
		getSubEscalaMasc().put(25,105);
		getSubEscalaMasc().put(24,101);
		getSubEscalaMasc().put(23,97);
		getSubEscalaMasc().put(22,94);
		getSubEscalaMasc().put(21,90);
		getSubEscalaMasc().put(20,86);
		getSubEscalaMasc().put(19,83);
		getSubEscalaMasc().put(18,79);
		getSubEscalaMasc().put(17,75);
		getSubEscalaMasc().put(16,72);
		getSubEscalaMasc().put(15,68);
		getSubEscalaMasc().put(14,64);
		getSubEscalaMasc().put(13,61);
		getSubEscalaMasc().put(12,57);
		getSubEscalaMasc().put(11,53);
		getSubEscalaMasc().put(10,49);
		getSubEscalaMasc().put(9,46);
		getSubEscalaMasc().put(8,42);
		getSubEscalaMasc().put(7,39);
		getSubEscalaMasc().put(6,37);
		getSubEscalaMasc().put(5,34);
		getSubEscalaMasc().put(4,32);
		getSubEscalaMasc().put(3,31);
		getSubEscalaMasc().put(2,30);

		// PA Femenino
		getSubEscalaFem().put(30,120);
		getSubEscalaFem().put(29,118);
		getSubEscalaFem().put(28,114);
		getSubEscalaFem().put(27,111);
		getSubEscalaFem().put(26,106);
		getSubEscalaFem().put(25,103);
		getSubEscalaFem().put(24,100);
		getSubEscalaFem().put(23,96);
		getSubEscalaFem().put(22,92);
		getSubEscalaFem().put(21,89);
		getSubEscalaFem().put(20,85);
		getSubEscalaFem().put(19,81);
		getSubEscalaFem().put(18,78);
		getSubEscalaFem().put(17,74);
		getSubEscalaFem().put(16,70);
		getSubEscalaFem().put(15,67);
		getSubEscalaFem().put(14,64);
		getSubEscalaFem().put(13,59);
		getSubEscalaFem().put(12,56);
		getSubEscalaFem().put(11,52);
		getSubEscalaFem().put(10,49);
		getSubEscalaFem().put(9,45);
		getSubEscalaFem().put(8,42);
		getSubEscalaFem().put(7,39);
		getSubEscalaFem().put(6,37);
		getSubEscalaFem().put(5,34);
		getSubEscalaFem().put(4,32);
		getSubEscalaFem().put(3,31);
		getSubEscalaFem().put(2,30);

	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.PA_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.PA_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_PA;
	}

}
