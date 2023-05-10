package com.appjpa.jpa.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Modalidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ModalidadDAOImpl implements IModalidadDAO {
    
    @PersistenceContext
    private EntityManager mo;

    //Guardar
    @Override
    @Transactional
    public void guardarMod(Modalidad modalidad) {
        if(modalidad.getId()!=null && modalidad.getId()>0){
            mo.merge(modalidad);
        }else{
          mo.persist(modalidad);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Modalidad> listarModalidad() {
        return mo.createQuery("from Modalidad").getResultList();
    }

    @Override
    @Transactional
    public Modalidad editarModalidad(Long id) {
        return mo.find(Modalidad.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarModalidad(Long id) {
        mo.remove(editarModalidad(id));
    }





    //LISTAR NOMBRE DE MODALIDAD
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Modalidad> listarNomModalidad() {
        return mo.createQuery("Select m.nombreModalidad From Modalidad m").getResultList();
    }

    @Override
    @Transactional
    public Modalidad obtenerModalidadPorId(Long id) {
        Session currentSession = mo.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("FROM Modalidad m WHERE m.id=:id", Modalidad.class);
        theQuery.setParameter("id", id);
        Modalidad laModalidad = null;
        try {
            laModalidad = (Modalidad) theQuery.getSingleResult();
        } catch (Exception e) {
            laModalidad = null;
        }
        return laModalidad;
    }
}
