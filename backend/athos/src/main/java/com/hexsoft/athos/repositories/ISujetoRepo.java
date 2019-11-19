package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.SujetoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISujetoRepo extends JpaRepository<SujetoDAO, String> {

    //List<SujetoDAO> findByDni(String dni);

}
