package com.hexsoft.athos.test.mmpi2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.hexsoft.athos.entities.Respuesta;
import com.hexsoft.athos.test.ICalculador;

public class CalculadorMMPI2 implements ICalculador {

	private JSONObject answers = null;
	private Map<String, Map<Integer, Integer>> lScale = new HashMap<>();
	private Map<String, Map<Integer, Integer>> fScale = new HashMap<>();	
	
	@Override
	public String procesarRespuestas(List<Respuesta> respuestas) {
		this.answers = respuestas.get(0).getAnswersAsJson();
		try {
			initScaleConstant();
			buildBasicScales();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void initScaleConstant() {
		Map<Integer, Integer> lScaleM = new HashMap<>();
		Map<Integer, Integer> lScaleF = new HashMap<>();
		
		// L Masculina
		lScaleM.put(0, 35);
		lScaleM.put(1, 39);
		lScaleM.put(2, 43);
		lScaleM.put(3, 48);
		lScaleM.put(4, 52);
		lScaleM.put(5, 56);
		lScaleM.put(6, 61);
		lScaleM.put(7, 65);
		lScaleM.put(8, 70);
		lScaleM.put(9, 74);
		lScaleM.put(10, 78);
		lScaleM.put(11, 83);
		lScaleM.put(12, 87);
		lScaleM.put(13, 91);
		lScaleM.put(14, 96);
		lScaleM.put(15, 100);
		
		// L Femenina
		lScaleF.put(0, 33);
		lScaleF.put(1, 38);
		lScaleF.put(2, 43);
		lScaleF.put(3, 47);
		lScaleF.put(4, 52);
		lScaleF.put(5, 57);
		lScaleF.put(6, 62);
		lScaleF.put(7, 66);
		lScaleF.put(8, 71);
		lScaleF.put(9, 76);
		lScaleF.put(10, 81);
		lScaleF.put(11, 86);
		lScaleF.put(12, 90);
		lScaleF.put(13, 95);
		lScaleF.put(14, 100);
		lScaleF.put(15, 105);
		
		lScale.put(MMPIConstants.L_SCALE_M, lScaleM);
		lScale.put(MMPIConstants.L_SCALE_F, lScaleF);
	}

	private void buildBasicScales() throws JSONException {
		getLscore();
		getFscore();
		getKscore();
		getHSscore();
		getDscore();
		getHYscore();
		getPDscore();
		getMFFscore();
		getMFMscore();
		getPAscore();
		getPTscore();
		getSCscore();
		getMAscore();
		getSIscore();
	}

	private void getSIscore() {
				
	}

	private void getMAscore() {
		// TODO Auto-generated method stub
		
	}

	private void getSCscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPTscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPAscore() {
		// TODO Auto-generated method stub
		
	}

	private void getMFMscore() {
		// TODO Auto-generated method stub
		
	}

	private void getMFFscore() {
		// TODO Auto-generated method stub
		
	}

	private void getPDscore() {
		// K*.04
		
	}

	private void getHYscore() {
		// TODO Auto-generated method stub
		
	}

	private void getDscore() {
		// TODO Auto-generated method stub
		
	}

	private void getHSscore() {
		// K*0.5
		
	}

	private void getKscore() {
		// TODO Auto-generated method stub
		
	}

	private JSONObject getFscore() throws JSONException {
		return getScore(MMPIConstants.F_ANSWERS_T, MMPIConstants.F_ANSWERS_F, fScale);
	}

	private JSONObject getLscore() throws JSONException {	
		return getScore(MMPIConstants.L_ANSWERS_T, MMPIConstants.L_ANSWERS_F, lScale);
	}
	
	private JSONObject getScore(Integer[] answersToCheckT, Integer[] answersToCheckF, Map<String, Map<Integer, Integer>> scale) throws JSONException {
		JSONObject result = new JSONObject();
		Integer pb = new Integer(0);
		
		for (Integer answerNbr : answersToCheckT){
			Boolean ans = (Boolean) answers.get(answerNbr.toString());
			pb = (ans != null && ans)? pb++ : pb;
		}
		
		for (Integer answerNbr : answersToCheckF){
			Boolean ans = (Boolean) answers.get(answerNbr.toString());
			pb = (ans != null && !ans)? pb++ : pb;
		}
		
		Integer ptm = scale.get(MMPIConstants.L_SCALE_M).get(pb);
		Integer ptf = scale.get(MMPIConstants.L_SCALE_F).get(pb);
		
		result.put(MMPIConstants.PB, pb)
			.put(MMPIConstants.PTM, ptm)
			.put(MMPIConstants.PTF, ptf);
		
		return result;
	}

}
