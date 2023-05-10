package com.appjpa.jpa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appjpa.jpa.dao.IEstudianteDAO;
import com.appjpa.jpa.entity.Estudiante;

import jakarta.servlet.http.HttpSession;

@Controller
public class EstudianteController {

    @Autowired
    private IEstudianteDAO estudianteDAO;


    @PostMapping(value="/datos-personales" )
    public String procesarDatosEstudiante(HttpSession session,
                                          @RequestParam Long dni,
                                          @RequestParam String nombres,
                                          @RequestParam String apellidos,
                                          @RequestParam Long edad,
                                          @RequestParam Long telefono,
                                          @RequestParam String direccion,
                                          @RequestParam String email){
        /*estudianteDAO.guardarE(estudiante);*/
        
        Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");
        if(estudiante == null) {
            estudiante = new Estudiante();
        }
        estudiante.setDni(dni);
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setEdad(edad);
        estudiante.setTelefono(telefono);
        estudiante.setDireccion(direccion);
        estudiante.setEmail(email);
        session.setAttribute("estudiante", estudiante);
        return "redirect:inscripcion-carrera";
    }

    @GetMapping(value="/datos-personales")
    public String crear(Model model, HttpSession session){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "datos-personales";
    }

    @GetMapping(value="/lista-datos-personales")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de estudiantes");
        model.addAttribute("estudiante", estudianteDAO.listarEstudiante());
        return "lista-datos-personales";
    }

    @GetMapping(value="/editar-datos-personales/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String,Object> model) {

        Estudiante estudiante = null;
        if(id>0){
            estudiante = estudianteDAO.editarEstudiante(id);
        } else {
            return "redirect:/listar";
        }
        model.put("titulo","Editar Datos Personales");
        model.put("estudiante", estudiante);
        return "datos-personales";
    }

    @GetMapping(value="/eliminar-datos-personales/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
        if(id>0) {
            estudianteDAO.eliminarEstudiante(id);
        }
        return "redirect:/lista-datos-personales";
    }
    
}
