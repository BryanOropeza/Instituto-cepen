package com.appjpa.jpa.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="modalidad")
public class Modalidad {
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreModalidad;

    @OneToMany(mappedBy = "modalidad")
    private List<Matricula> matriculas;

    
    public Modalidad() {
    }

    

    
    public Modalidad(Long id, String nombreModalidad, List<Matricula> matriculas) {
        this.id = id;
        this.nombreModalidad = nombreModalidad;
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
    public String getNombreModalidad() {
        return nombreModalidad;
    }
    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    
}
