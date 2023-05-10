package com.appjpa.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appjpa.jpa.dao.IRolesDAO;
import com.appjpa.jpa.dao.IUsuario;
import com.appjpa.jpa.entity.Roles;
import com.appjpa.jpa.entity.Usuario;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuario userDAO;
    @Autowired
    private IRolesDAO rolesDAO;

    @PostMapping(value = "/login")
    public String grabar(@ModelAttribute("user") Usuario usuario, Model model) {
        Usuario usuarioBD = userDAO.findByUsername(usuario.getUsername());
        if (usuarioBD != null && usuario.getPassword().equals(usuarioBD.getPassword())) {
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping(value = "/login")
    public String entrar(Model model) {
        Usuario user = new Usuario();
        model.addAttribute("titulo", "Ingreso al sistema");
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping(value = "/acceso-sistema")
    public String crearUsers(Model model, HttpSession session) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        List<Roles> roles = rolesDAO.listarRoles();
        model.addAttribute("roles", roles);
        return "acceso-sistema";
    }

    @PostMapping(value = "/acceso-sistema")
    public String guardarUser(HttpSession session,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Long rolesId) {
        Usuario usuario = new Usuario();
        // Usuario usuario = (Usuario) session.getAttribute("usuario");
        Roles roles = rolesDAO.editarRoles(rolesId);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setRoles(roles);
        userDAO.guardarUsu(usuario);
        session.setAttribute("usuario", usuario);

        return "redirect:index";
    }

    @GetMapping(value = "/asignar-rol")
    public String asignarRol(Long id, Model model, HttpSession session) {

        List<Usuario> usuarios = userDAO.listarUsuario();

        model.addAttribute("usuarios", usuarios);

        List<Roles> roles = rolesDAO.listarRoles();
        model.addAttribute("roles", roles);

        return "asignar-rol";

    }

    @PostMapping(value = "/actualizar-rol")
    public String actualizarRolUser(HttpSession session,
            @RequestParam Long usuarioId,
            @RequestParam Long rolesId,
            Model model) {

        Usuario usuario = userDAO.editarUsuario(usuarioId);
        Roles roles = rolesDAO.editarRoles(rolesId);
        usuario.setRoles(roles);
        userDAO.guardarUsu(usuario);

        model.addAttribute("usuarios", usuario);

        return "redirect:index";
    }

}
