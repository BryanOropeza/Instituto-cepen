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
@Table(name="estudiante")
public class Estudiante implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dni;
    private String nombres;
    private String apellidos;
    private Long edad;
    private Long telefono;
    private String direccion;
    private String email;

    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "estudiante")
    private List<GenerarPago> generarpagos;

    @OneToMany(mappedBy = "estudiante")
    private List<Notas> notas;

    


    public Estudiante() {
    }

    

    public Estudiante(Long id, Long dni, String nombres, String apellidos, Long edad, Long telefono, String direccion,
            String email, List<Matricula> matriculas, List<GenerarPago> generarpagos, List<Notas> notas) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.matriculas = matriculas;
        this.generarpagos = generarpagos;
        this.notas = notas;
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
    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Long getEdad() {
        return edad;
    }
    public void setEdad(Long edad) {
        this.edad = edad;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

    