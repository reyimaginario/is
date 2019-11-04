package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.TestAplicadoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestAplicadoRepo extends JpaRepository<TestAplicadoDAO, Long> {
}
