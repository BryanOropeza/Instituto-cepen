package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.GenerarPago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GenerarPagoDAOimpl implements IGenerarPagoDAO {

    @PersistenceContext
    private EntityManager pa;

    @Override
    @Transactional
    public void guardarPago(GenerarPago generarpago) {
        if(generarpago.getId()!=null && generarpago.getId()>0){
            pa.merge(generarpago);
        }else{
          pa.persist(generarpago);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<GenerarPago> listarPago() {
        return pa.createQuery("from GenerarPago").getResultList();
    }

    @Override
    @Transactional
    public GenerarPago editarPago(Long id) {
        return pa.find(GenerarPago.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarPago(Long id) {
        pa.remove(editarPago(id));
    }
    
}
