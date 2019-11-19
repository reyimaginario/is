package com.hexsoft.athos.controllers;

import com.hexsoft.athos.services.TestService;
import com.hexsoft.athos.test.ATest;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/{testCode}/preguntas")
    public JSONObject probarPreguntasJASON(@PathVariable(value = "testCode") String testCode) {


        TestService testService = TestService.getInstance();
        ATest test = testService.obtenerTest(testCode.toUpperCase());
        JSONObject jason = null;

        try {
            jason =  test.obtenerPreguntasComoJSON();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jason;

    }


}
