package com.appjpa.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    //Método:
    //2 Variantes : @GetMapping / @PostMapping [Por defecto @RM es Get]
    @RequestMapping(value={"/home", "/inicio", "/index", "/"})
    public String index(Model model){
        model.addAttribute("titulo","Proyecto");
        model.addAttribute("proyecto", "Bienvenidos al Sistema de Matrícula CEPEN");
        model.addAttribute("programador", "Jean Carlos Lozano Curi");
        return "index";
    }
}

