package com.hexsoft.athos.controllers;
/*
import com.hexsoft.athos.test.ATest;
import com.hexsoft.athos.test.ConstantestServicioTest;
import com.hexsoft.athos.test.TestService;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
*/
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController(value = "/xxx")
public class ProbandoCosasController {

/*
    @GetMapping
    public JSONObject probarPreguntasJASON(){

        TestService testService = TestService.getInstance();

        ATest test = testService.obtenerTest(ConstantestServicioTest.CODIGO_TEST_MMPI2);

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
*/
}
