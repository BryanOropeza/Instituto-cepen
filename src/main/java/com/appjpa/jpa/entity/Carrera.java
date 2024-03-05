package com.appjpa.jpa.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar
    private Long id;
    private String carrera;

    @OneToMany(mappedBy = "carrera")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "carrera")
    private List<Curso> curso;

    public Carrera() {
    }

    public Carrera(Long id, String carrera, List<Matricula> matriculas, List<Curso> curso) {
        this.id = id;
        this.carrera = carrera;
        this.matriculas = matriculas;
        this.curso = curso;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
