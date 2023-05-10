package com.appjpa.jpa.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable{

    private static final long serialVersionUID=1L; //Concatenado a la AutogeneraciÃ³n

    @Id  //Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autogenerar
    private Long id;
    private String nombre;
    private String horaInicio;
    private String horaFin;
    private String ciclo;
    private int credito;


    @OneToMany(mappedBy = "curso")
    private List<GenerarHorario> generarHorarios;

    @ManyToOne
    @JoinColumn(name="id_carrera")
    private Carrera carrera;

    


    
    public Curso() {
    }

    


    public Curso(Long id, String nombre, String horaInicio, String horaFin, String ciclo, int credito,
             List<GenerarHorario> generarHorarios, Carrera carrera) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ciclo = ciclo;
        this.credito = credito;
        this.generarHorarios = generarHorarios;
        this.carrera = carrera;
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    public int getCredito() {
        return credito;
    }
    public void setCredito(int credito) {
        this.credito = credito;
    }

    //Get and Set
    

    
    
}
