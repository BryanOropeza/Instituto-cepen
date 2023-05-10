package com.appjpa.jpa.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Carrera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CarreraDAOImpl implements ICarreraDAO{

    //Un objeto:
    @PersistenceContext
    private EntityManager ca;

    @Override
    @Transactional
    public void guardarCar(Carrera carrera) {
        if(carrera.getId()!=null && carrera.getId()>0){
            ca.merge(carrera);
        }else{
          ca.persist(carrera);      
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Carrera> listarCarrera() {
        return ca.createQuery("from Carrera").getResultList();
    }


    //Lista solamente el nombre de la carrera
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Carrera> listarNomCarrera() {
        return ca.createQuery("Select c.carrera From Carrera c").getResultList();
    }

    @Override
    @Transactional
    public Carrera editarCarrera(Long id) {
        return ca.find(Carrera.class, id);
    }


    @Override
    @Transactional
    public void eliminarCarrera(Long id) {
        ca.remove(editarCarrera(id));
    }

    @Override
    @Transactional
    public Carrera obtenerCarreraPorId(Long id) {
        Session currentSession = ca.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("FROM Carrera c WHERE c.id=:id", Carrera.class);
        theQuery.setParameter("id", id);
        Carrera laCarrera = null;
        try {
            laCarrera = (Carrera) theQuery.getSingleResult();
        } catch (Exception e) {
            laCarrera = null;
        }
        return laCarrera;
    }
    
}
