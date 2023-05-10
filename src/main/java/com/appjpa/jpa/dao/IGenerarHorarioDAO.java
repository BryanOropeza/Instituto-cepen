package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.GenerarHorario;

public interface IGenerarHorarioDAO {
    
    public void guardarHorario(GenerarHorario generarhorario);

    public List<GenerarHorario> listarHorario();

    public GenerarHorario editarHorario(Long id);

    public void eliminarHorario(Long id);
}
