package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.RespuestaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRespuestaRepo extends JpaRepository<RespuestaDAO, Long> {
}
