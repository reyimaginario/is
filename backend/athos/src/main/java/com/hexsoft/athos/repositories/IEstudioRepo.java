package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.EstudioDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepo extends JpaRepository<EstudioDAO, Long> {
}
