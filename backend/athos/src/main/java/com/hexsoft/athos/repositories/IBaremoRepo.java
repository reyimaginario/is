package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.BaremoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaremoRepo extends JpaRepository<BaremoDAO, Long> {
    List<BaremoDAO> findByLocalidadAndEdadAndGeneroAndNivelDeEstudioAndOcupacion(String localidad, String edad, String genero, String nivelDeEstudio, String ocupacion);
}
