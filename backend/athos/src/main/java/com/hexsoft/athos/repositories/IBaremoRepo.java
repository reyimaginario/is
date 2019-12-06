package com.hexsoft.athos.repositories;

import com.hexsoft.athos.entities.BaremoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaremoRepo extends JpaRepository<BaremoDAO, Long> {

    @Query(value =  "select * " +
                    "from baremo " +
                    "where  (?1 is null or localidad = ?1) and " +
                    "       (?2 is null or edad >= ?2) and " +
                    "       (?3 is null or edad <= ?3) and " +
                    "       (?4 is null or genero = ?4) and " +
                    "       (?5 is null or nivel_de_estudio = ?5) and " +
                    "       (?6 is null or ocupacion = ?6)",
            nativeQuery = true)
    List<BaremoDAO> obtenerBaremosFiltradosSQL(String localidad, String edadDesde, String edadHasta, String genero, String nivelDeEstudio, String ocupacion);
}
