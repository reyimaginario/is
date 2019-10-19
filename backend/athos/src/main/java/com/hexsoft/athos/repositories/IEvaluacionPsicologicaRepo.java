package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluacionPsicologicaRepo extends JpaRepository<EvaluacionPsicologicaDAO, Long> {



}
