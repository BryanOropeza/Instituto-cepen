package com.appjpa.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="generar_pago")
public class GenerarPago implements Serializable {
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroTarjeta;
    private Date fechaPago;
    private Long cvv;

    

    @ManyToOne
    @JoinColumn(name="id_estudiante")
    private Estudiante estudiante;


    
    public GenerarPago() {
    }

    

    public GenerarPago(Long id, Long numeroTarjeta, Date fechaPago, Long cvv,
            Estudiante estudiante) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
        this.cvv = cvv;
        this.estudiante = estudiante;
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
    public Long getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public Date getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public Long getCvv() {
        return cvv;
    }
    public void setCvv(Long cvv) {
        this.cvv = cvv;
    }



    public Estudiante getEstudiante() {
        return estudiante;
    }



    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
}   