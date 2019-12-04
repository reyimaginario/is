package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.LocalidadDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalidadRepo extends JpaRepository<LocalidadDAO, Long> {
}
