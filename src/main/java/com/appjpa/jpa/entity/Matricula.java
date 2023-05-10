package com.appjpa.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula implements Serializable {

     
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_carrera")
    private Carrera carrera;
    
    
    @ManyToOne
    @JoinColumn(name="id_estudiante")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name="id_modalidad")
    private Modalidad modalidad;
    
    @ManyToOne
    @JoinColumn(name="id_turno")
    private Turno turno;
    
    private Date fechaInscripcion;

    @PrePersist
    public void prePersist() {
        fechaInscripcion = new Date();
    }

    public Matricula() {
    }

    

    public Matricula(Long id, Carrera carrera, Estudiante estudiante, Modalidad modalidad, Turno turno,
            Date fechaInscripcion) {
        this.id = id;
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.modalidad = modalidad;
        this.turno = turno;
        this.fechaInscripcion = fechaInscripcion;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    
}
