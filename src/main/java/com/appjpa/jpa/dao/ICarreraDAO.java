package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Carrera;

public interface ICarreraDAO {
    
    public void guardarCar(Carrera Curso);
    
    public List<Carrera> listarCarrera();

    public List<Carrera> listarNomCarrera();

    public Carrera editarCarrera(Long id);

    public void eliminarCarrera(Long id);

    public Carrera obtenerCarreraPorId(Long id);

}

