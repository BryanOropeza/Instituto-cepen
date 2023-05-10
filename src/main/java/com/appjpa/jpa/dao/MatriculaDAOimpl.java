package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class MatriculaDAOimpl implements IMatriculaDAO {
    
    //Objeto
    @PersistenceContext
    private EntityManager ma;

    //Guardar
    @Override
    @Transactional
    public void guardarMat(Matricula matricula) {
        if(matricula.getId()!=null && matricula.getId()>0){
            ma.merge(matricula);
        }else{
          ma.persist(matricula);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Matricula> listarMatricula() {
        return ma.createQuery("from Matricula").getResultList();
    }


    @Override
    @Transactional
    public Matricula editarMatricula(Long id) {
        return ma.find(Matricula.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarMatricula(Long id) {
        ma.remove(editarMatricula(id));
    }

    @Override
    @Transactional
    public List<Object[]> listarDatosMatricula() {
        String jpql = "SELECT m, c, mo, t, e FROM Matricula m JOIN m.carrera c JOIN m.modalidad mo JOIN m.turno t JOIN m.estudiante e ";
        TypedQuery<Object[]> query = ma.createQuery(jpql, Object[].class);
        List<Object[]> resultados = query.getResultList();
        return resultados;
    }

}
