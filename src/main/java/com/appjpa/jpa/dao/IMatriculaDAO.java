package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Matricula;

public interface IMatriculaDAO {
    
    public void guardarMat(Matricula matricula);

    public List<Matricula> listarMatricula();

    public Matricula editarMatricula(Long id);

    public void eliminarMatricula(Long id);

    public List<Object[]> listarDatosMatricula();
}
