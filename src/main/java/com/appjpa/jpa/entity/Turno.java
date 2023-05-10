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
@Table(name="turno")
public class Turno implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreTurno;

    @OneToMany(mappedBy = "turno")
    private List<Matricula> matriculas;
    
    public Turno() {
    }

    


    public Turno(Long id, String nombreTurno, List<Matricula> matriculas) {
        this.id = id;
        this.nombreTurno = nombreTurno;
        this.matriculas = matriculas;
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
    public String getNombreTurno() {
        return nombreTurno;
    }
    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    
}
