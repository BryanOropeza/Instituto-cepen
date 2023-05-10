package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Modalidad;

public interface IModalidadDAO {
    
    public List<Modalidad> listarNomModalidad();

    public void guardarMod(Modalidad modalidad);

    public List<Modalidad> listarModalidad();

    public Modalidad editarModalidad(Long id);

    public void eliminarModalidad(Long id);

    public Modalidad obtenerModalidadPorId(Long id);
}
