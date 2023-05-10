package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Curso;

public  interface ICursoDAO {
    
    public void guardarCur(Curso Curso);
    
    public List<Curso> listarCurso();

    public Curso editarCurso(Long id);

    public void eliminarCurso(Long id);
    
    public List<Curso>listarNomCurso();
}
