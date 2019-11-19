package com.hexsoft.athos.services;

import java.util.HashMap;

import com.hexsoft.athos.test.ATest;
import com.hexsoft.athos.test.mmpi2.TestMMPI2;

public class TestService {
	
	private static TestService instance;
	private HashMap<String, ATest> registroDeTest;
	
	private TestService() {
		registroDeTest = new HashMap<String, ATest>();
		registroDeTest.put(TestMMPI2.CODIGO, new TestMMPI2());
	}

	public static TestService getInstance() {
		if (instance == null) {
			instance = new TestService();
		}
		return instance;
	}
	
	public ATest obtenerTest(String codigoTest) {
		return registroDeTest.get(codigoTest); 
	}
}