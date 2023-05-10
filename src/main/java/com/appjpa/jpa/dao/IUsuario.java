package com.appjpa.jpa.dao;


import java.util.List;

import com.appjpa.jpa.entity.Usuario;

public interface IUsuario{
    

    public void guardarUsu(Usuario user);

    public List<Usuario> listarUsuario();

    public Usuario editarUsuario(Long id);

    public void eliminarUsuario(Long id);

    Usuario findByUsername(String username);

}
