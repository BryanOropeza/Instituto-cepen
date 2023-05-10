package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Notas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class NotaDAOimpl implements INotaDAO{

    @PersistenceContext
    private EntityManager no;

    @Override
    @Transactional
    public void guardarNota(Notas notas) {
        if(notas.getId()!=null && notas.getId()>0){
            no.merge(notas);
        }else{
          no.persist(notas);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Notas> listarNotas() {
        return no.createQuery("from Notas").getResultList();
    }

    @Override
    @Transactional
    public Notas editarNota(Long id) {
        return no.find(Notas.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarNota(Long id) {
        no.remove(editarNota(id));
    }
    
}
