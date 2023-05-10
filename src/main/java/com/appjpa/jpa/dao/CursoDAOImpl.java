package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CursoDAOImpl implements ICursoDAO{
    
    //Un objeto:
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void guardarCur(Curso curso) {
        if(curso.getId()!=null && curso.getId()>0){
            em.merge(curso);
        }else{
          em.persist(curso);      
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Curso> listarCurso() {
        return em.createQuery("from Curso").getResultList();
    }

    @Override
    @Transactional
    public Curso editarCurso(Long id) {
        return em.find(Curso.class, id);
    }


    @Override
    @Transactional
    public void eliminarCurso(Long id) {
        em.remove(editarCurso(id));
    }

    //Lista solamente el nombre de la carrera
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Curso>listarNomCurso() {
        return em.createQuery("Select c.nombre From Curso c").getResultList();
    }
}
