package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.Sujeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISujetoRepo extends JpaRepository<Sujeto, Long> {

    List<Sujeto> findByDni(String dni);

}
