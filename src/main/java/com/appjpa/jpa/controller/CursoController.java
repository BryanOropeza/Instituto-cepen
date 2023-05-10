package com.appjpa.jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.appjpa.jpa.dao.ICursoDAO;
import com.appjpa.jpa.entity.Curso;


@Controller
public class CursoController {
    
    @Autowired
    private ICursoDAO cursoDAO;


    @PostMapping(value="/asignacion_horario")
    public String grabar(Curso curso){
        cursoDAO.guardarCur(curso);
        return "redirect:/lista_horario";
    }

    @GetMapping(value="/asignacion_horario")
    public String crear(Model model){
        List<Curso> cursos = cursoDAO.listarCurso();
        Curso curso = new Curso();
        model.addAttribute("titulo","Asignación de Horario");
        model.addAttribute("cursos", cursos);
        model.addAttribute("curso", curso);
        return "asignacion_horario";
    }


    @GetMapping(value="/lista_horario")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Cursos");
        model.addAttribute("curso", cursoDAO.listarCurso());
        return "lista_horario";
    }

    @GetMapping(value="/asignacion_horario/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String,Object> model) {

        Curso curso = null;
        if(id>0){
            curso = cursoDAO.editarCurso(id);
        } else {
            return "redirect:/listar";
        }
        model.put("titulo","Editar Curso");
        model.put("curso",curso);
        return "asignacion_horario";
    }

    @GetMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
        if(id>0) {
            cursoDAO.eliminarCurso(id);
        }
        return "redirect:/lista_horario";
    }


}

