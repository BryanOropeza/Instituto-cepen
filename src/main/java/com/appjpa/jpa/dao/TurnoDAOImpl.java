package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Turno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class TurnoDAOImpl implements ITurnoDAO{
    
    @PersistenceContext
    private EntityManager tu;

    //Guardar
    @Override
    @Transactional
    public void guardarTurno(Turno turno) {
        if(turno.getId()!=null && turno.getId()>0){
            tu.merge(turno);
        }else{
          tu.persist(turno);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Turno> listarTurno() {
        return tu.createQuery("from Turno").getResultList();
    }

    @Override
    @Transactional
    public Turno editarTurno(Long id) {
        return tu.find(Turno.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarTurno(Long id) {
        tu.remove(editarTurno(id));
    }


    //Listar Nombre de Turnos
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Turno> listarNomTurnos() {
        return tu.createQuery("Select t.nombreTurno From Turno t").getResultList();
    }

        
}
