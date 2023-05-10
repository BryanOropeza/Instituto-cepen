package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Roles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class IRolesDAOimpl implements IRolesDAO{

    @PersistenceContext
    private EntityManager ro;

    //Guardar
    @Override
    @Transactional
    public void guardarRol(Roles roles) {
        if(roles.getId()!=null && roles.getId()>0){
            ro.merge(roles);
        }else{
          ro.persist(roles);      
        }
    }

    //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Roles> listarRoles() {
        return ro.createQuery("from Roles").getResultList();
    }

    @Override
    @Transactional
    public Roles editarRoles(Long id) {
        return ro.find(Roles.class, id);
    }

    //Eliminar
    @Override
    @Transactional
    public void eliminarRoles(Long id) {
        ro.remove(editarRoles(id));
    }

    
}
