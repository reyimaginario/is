package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRespuestaTemporalRepo extends JpaRepository<RespuestaTemporalDAO, Long> {



}
