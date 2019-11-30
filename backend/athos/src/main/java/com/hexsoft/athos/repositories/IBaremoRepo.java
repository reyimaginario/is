package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.BaremoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaremoRepo extends JpaRepository<BaremoDAO, Long> {
}
