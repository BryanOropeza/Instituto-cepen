package com.appjpa.jpa.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Estudiante;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Repository
public class EstudianteDAOImpl implements IEstudianteDAO{

    @PersistenceContext
    private EntityManager es;

    @Override
    @Transactional
    public void guardarE(Estudiante estudiante) {
        if(estudiante.getId()!=null && estudiante.getId()>0){
            es.merge(estudiante);
        }else{
            es.persist(estudiante);      
         }
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiante() {
        return es.createQuery("from Estudiante").getResultList();
    }

    @Override
    @Transactional
    public Estudiante editarEstudiante(Long id) {
        return es.find(Estudiante.class, id);
    }


    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        es.remove(editarEstudiante(id));
    }

    @Override
    @Transactional
    public Estudiante buscarporId(Long id) {
    return es.find(Estudiante.class, id);
}
    
}
