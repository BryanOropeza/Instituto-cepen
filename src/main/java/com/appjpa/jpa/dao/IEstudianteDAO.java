package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Estudiante;

public interface IEstudianteDAO{
    //Guardar
    public void guardarE(Estudiante estudiante);

    public List<Estudiante> listarEstudiante();

    public Estudiante editarEstudiante(Long id);

    public void eliminarEstudiante(Long id);

    public Estudiante buscarporId(Long id);
}
