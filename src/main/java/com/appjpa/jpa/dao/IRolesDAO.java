package com.appjpa.jpa.dao;

import java.util.List;

import com.appjpa.jpa.entity.Roles;

public interface IRolesDAO {

    public void guardarRol(Roles roles);
    public List<Roles> listarRoles();
    public Roles editarRoles(Long id);
    public void eliminarRoles(Long id);
    
}
