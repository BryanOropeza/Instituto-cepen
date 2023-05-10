package com.appjpa.jpa.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appjpa.jpa.dao.ICarreraDAO;
import com.appjpa.jpa.dao.IEstudianteDAO;
import com.appjpa.jpa.dao.IGenerarPagoDAO;
import com.appjpa.jpa.dao.IMatriculaDAO;
import com.appjpa.jpa.dao.IModalidadDAO;
import com.appjpa.jpa.dao.ITurnoDAO;
import com.appjpa.jpa.entity.Carrera;
import com.appjpa.jpa.entity.Estudiante;
import com.appjpa.jpa.entity.GenerarPago;
import com.appjpa.jpa.entity.Matricula;
import com.appjpa.jpa.entity.Modalidad;
import com.appjpa.jpa.entity.Turno;

import jakarta.servlet.http.HttpSession;

@Controller
public class InscripcionCarreraController {
    
    @Autowired
    private ICarreraDAO carreraDAO;
    @Autowired
    private ITurnoDAO turnoDAO;
    @Autowired
    private IModalidadDAO modalidadDAO;
    @Autowired
    private IEstudianteDAO estudianteDAO;
    @Autowired
    private IMatriculaDAO matriculaDAO;
    @Autowired 
    private IGenerarPagoDAO pagoDAO;

    /*
    @PostMapping(value="/carrera")
    public String grabar(Carrera carrera){
        carreraDAO.guardarCar(carrera);
        return "redirect:/lista-carrera";
    }
    */

    /*  
    @GetMapping(value="/carrera")
    public String crear(Model model){
        Carrera carrera = new Carrera();
        model.addAttribute("titulo", "Carrera");
        model.addAttribute("carrera", carrera);
        return "carrera";
    }
    */
    

    /* 
    @GetMapping(value="/lista-carrera")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Carrera");
        model.addAttribute("carrera", carreraDAO.listarCarrera());
        return "lista-carrera";
    }
    */
    @GetMapping("/inscripcion-carrera")
    public String inscripcionCarrera(Model model) {
        List<Carrera> carreras = carreraDAO.listarCarrera();
        List<Turno> turnos = turnoDAO.listarTurno();
        List<Modalidad> modalidades = modalidadDAO.listarModalidad();
        
        model.addAttribute("carreras", carreras);
        model.addAttribute("turnos", turnos);
        model.addAttribute("modalidades", modalidades);
        
        return "inscripcion-carrera";
    }

    @PostMapping("/inscripcion-carrera")
    public String procesarInscripcionCarrera(@RequestParam Long carreraId,
                                             @RequestParam Long turnoId,
                                             @RequestParam Long modalidadId,
                                             Model model,
                                             HttpSession session) {
        Matricula matricula = new Matricula();
        model.addAttribute("marticula", matricula);
        Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");
        Carrera carrera = carreraDAO.editarCarrera(carreraId);
        Turno turno = turnoDAO.editarTurno(turnoId);
        Modalidad modalidad = modalidadDAO.editarModalidad(modalidadId);
        
        session.setAttribute("carreras", carrera);
        session.setAttribute("turnos", turno);
        session.setAttribute("modalidades", modalidad);
        
        model.addAttribute("carrera", carrera);
        model.addAttribute("turno", turno);
        model.addAttribute("modalidad", modalidad);
        model.addAttribute("estudiante", estudiante);
        

        return"redirect:pago";
    }
      

    @GetMapping(value="/pago")
    public String pago (Model model){
        GenerarPago generarPago = new GenerarPago();
        model.addAttribute("generarPago", generarPago);
        return "pago";
    }

    //POST 
    @PostMapping(value="/pago")
    public String guardarPago(Model model, HttpSession session,
                            @RequestParam Long numeroTarjeta,
                            @RequestParam Long cvv,
                            @RequestParam Date fechaPago){

        GenerarPago generarPago = new GenerarPago();
        model.addAttribute("generarPago", generarPago);

        Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");
        if (estudiante != null){
            estudianteDAO.guardarE(estudiante);
        }
        Carrera carrera = (Carrera) session.getAttribute("carreras");
        Turno turno = (Turno) session.getAttribute("turnos");
        Modalidad modalidad = (Modalidad) session.getAttribute("modalidades");
        //Matricula matricula = (Matricula) session.getAttribute("matriculas");
        
        Matricula matricula = new Matricula();
        
        generarPago.setCvv(cvv);
        generarPago.setNumeroTarjeta(numeroTarjeta);
        generarPago.setEstudiante(estudiante);
        generarPago.setFechaPago(fechaPago);

        matricula.setCarrera(carrera);
        matricula.setTurno(turno);
        matricula.setModalidad(modalidad);
        matricula.setEstudiante(estudiante);
        matriculaDAO.guardarMat(matricula);

        session.setAttribute("estudiante", estudiante);
        session.setAttribute("matricula", matricula);
        session.setAttribute("generarPago", generarPago);

        
        pagoDAO.guardarPago(generarPago);

        return "redirect:constancia-matricula";
    }

    @GetMapping(value="/lista-matriculas")
    public String listasMat(Model model){
        model.addAttribute("matriculas", matriculaDAO.listarDatosMatricula());
        return "lista-matriculas";
    }

    @GetMapping(value="/listar-carrera")
    public String listarCarreras(Model model){
        model.addAttribute("carreras", carreraDAO.listarCarrera());
        return "listar-carrera";
    }

        

    

    @GetMapping(value="/constancia-matricula")
    public String constanciaMat(Model model, HttpSession session){
        Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");
        Matricula matricula = (Matricula) session.getAttribute("matricula");
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("matricula", matricula);
        GenerarPago generarPago = (GenerarPago) session.getAttribute("generarPago");
        model.addAttribute("generarPago", generarPago);
        return "constancia-matricula";
    }

}


    /*
    @GetMapping(value="/carrera/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
        Carrera carrera = null;
        if(id>0){
            carrera = carreraDAO.editarCarrera(id);
        } else {
            return "redirect:/listar";
        }
        model.put("titulo", "Esitar Carrera");
        model.put("carrera", carrera);
        return "carrera";
    }
    */
    /*
    @GetMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id>0) {
            carreraDAO.eliminarCarrera(id);
        }
        return "redirect:/lista-carrera";
    }
    */


