package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.OcupacionDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOcupacionRepo extends JpaRepository<OcupacionDAO, Long> {
}
