package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.GeneroDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepo extends JpaRepository<GeneroDAO, Long> {
}
