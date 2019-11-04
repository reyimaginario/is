package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.TestAplicadoDAO;
import com.hexsoft.athos.repositories.ITestAplicadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestAplicadoService {

    @Autowired
    private ITestAplicadoRepo testAplicadoRepo;


    public TestAplicadoDAO obetenerTestAplicado(Long testAplicadoId) {
        TestAplicadoDAO testAplicadoDAO = null;
        Optional<TestAplicadoDAO> testAplicadoDAOOptional = testAplicadoRepo.findById(testAplicadoId);
        if (testAplicadoDAOOptional.isPresent()) {
            testAplicadoDAO = testAplicadoDAOOptional.get();
        }
        return testAplicadoDAO;
    }

    public TestAplicadoDAO obtenerTestAplicadoBy
            
}
