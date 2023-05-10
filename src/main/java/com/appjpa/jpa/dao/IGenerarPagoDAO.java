package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.GenerarPago;

public interface IGenerarPagoDAO {

    public void guardarPago(GenerarPago generarpago);

    public List<GenerarPago> listarPago();

    public GenerarPago editarPago(Long id);
    
    public void eliminarPago(Long id);
    
}
