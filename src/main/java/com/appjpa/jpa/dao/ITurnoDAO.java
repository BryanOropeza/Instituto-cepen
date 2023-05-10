package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Turno;

public interface ITurnoDAO {

public List<Turno> listarNomTurnos();

public void guardarTurno(Turno turno);

public List<Turno> listarTurno();

public Turno editarTurno(Long id);

public void eliminarTurno(Long id);



}
