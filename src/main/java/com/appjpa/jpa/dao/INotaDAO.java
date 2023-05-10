package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Notas;

public interface INotaDAO {
    
    public void guardarNota(Notas notas);

    public List<Notas> listarNotas();

    public Notas editarNota(Long id);

    public void eliminarNota(Long id);
}
