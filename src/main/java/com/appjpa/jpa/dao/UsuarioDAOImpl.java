package com.appjpa.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appjpa.jpa.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioDAOImpl implements IUsuario{
    
    @PersistenceContext
    private EntityManager pe;

    @Override
    @Transactional
    public void guardarUsu(Usuario user) {
        if(user.getId()!=null && user.getId()>0){
            pe.merge(user);
        }else{
          pe.persist(user);      
        }
    }

     //Listar
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
     public List<Usuario> listarUsuario() {
         return pe.createQuery("from Usuario").getResultList();
     }
 
     @Override
     @Transactional
     public Usuario editarUsuario(Long id) {
         return pe.find(Usuario.class, id);
     }
 
     //Eliminar
     @Override
     @Transactional
     public void eliminarUsuario(Long id) {
         pe.remove(editarUsuario(id));
     }

     //buscar por Username
     @Override
     @Transactional
     public Usuario findByUsername(String username) {
         String jpql = "SELECT u FROM Usuario u WHERE u.username = :username";
         TypedQuery<Usuario> query = pe.createQuery(jpql, Usuario.class);
         query.setParameter("username", username);
         try {
             return query.getSingleResult();
         } catch (NoResultException ex) {
             return null;
         }
     }
 
}

