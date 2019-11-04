package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesMMPIContenido;

public class CalculadorSubescalaL extends ACalculadorSubescalas {

	private static CalculadorSubescalaL instance;
	
	private CalculadorSubescalaL() {
		inicializarConstantesMyF();
	}
	
	public static ACalculadorSubescalas getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaL();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		
		// L Masculina
		getSubEscalaMasc().put(0, 35);
		getSubEscalaMasc().put(1, 39);
		getSubEscalaMasc().put(2, 43);
		getSubEscalaMasc().put(3, 48);
		getSubEscalaMasc().put(4, 52);
		getSubEscalaMasc().put(5, 56);
		getSubEscalaMasc().put(6, 61);
		getSubEscalaMasc().put(7, 65);
		getSubEscalaMasc().put(8, 70);
		getSubEscalaMasc().put(9, 74);
		getSubEscalaMasc().put(10, 78);
		getSubEscalaMasc().put(11, 83);
		getSubEscalaMasc().put(12, 87);
		getSubEscalaMasc().put(13, 91);
		getSubEscalaMasc().put(14, 96);
		getSubEscalaMasc().put(15, 100);
		
		// L Femenina
		getSubEscalaFem().put(0, 33);
		getSubEscalaFem().put(1, 38);
		getSubEscalaFem().put(2, 43);
		getSubEscalaFem().put(3, 47);
		getSubEscalaFem().put(4, 52);
		getSubEscalaFem().put(5, 57);
		getSubEscalaFem().put(6, 62);
		getSubEscalaFem().put(7, 66);
		getSubEscalaFem().put(8, 71);
		getSubEscalaFem().put(9, 76);
		getSubEscalaFem().put(10, 81);
		getSubEscalaFem().put(11, 86);
		getSubEscalaFem().put(12, 90);
		getSubEscalaFem().put(13, 95);
		getSubEscalaFem().put(14, 100);
		getSubEscalaFem().put(15, 105);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.L_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.L_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_L;
	}
}
