package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.ProfesionalDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesionalRepo extends JpaRepository<ProfesionalDAO, String> {

    //List<ProfesionalDAO> findByDni(String dni);

}
