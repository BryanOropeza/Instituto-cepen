package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.GenerarHorario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GenerarHorarioDAOimpl  implements IGenerarHorarioDAO{
    @PersistenceContext
    private EntityManager ho;
    
    //Guardar
    @Override
    @Transactional
    public void guardarHorario(GenerarHorario generarhorario) {
        if(generarhorario.getId()!=null && generarhorario.getId()>0){
            ho.merge(generarhorario);
        }else{
          ho.persist(generarhorario);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<GenerarHorario> listarHorario() {
        return ho.createQuery("from GenerarHorario").getResultList();
    }

    @Override
    @Transactional
    public GenerarHorario editarHorario(Long id) {
        return ho.find(GenerarHorario.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarHorario(Long id) {
        ho.remove(editarHorario(id));
    }

}
