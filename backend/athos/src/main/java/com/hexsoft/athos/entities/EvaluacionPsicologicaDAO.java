package com.hexsoft.athos.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evaluacionPsicologica")
public class EvaluacionPsicologicaDAO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long evaluacionId;

    private Date fechaInicio;

    private Date fechaFin;

    private ProfesionalDAO profesional;

    private SujetoDAO sujeto;

    private List<TestAplicadoDAO> listaTestsAplicados;

    private String informe;


}
