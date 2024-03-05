package com.appjpa.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import com.appjpa.jpa.entity.Carrera;
import com.appjpa.jpa.entity.Curso;
import com.appjpa.jpa.entity.Modalidad;
import com.appjpa.jpa.entity.Roles;
import com.appjpa.jpa.entity.Turno;
import com.appjpa.jpa.dao.ICarreraDAO;
import com.appjpa.jpa.dao.ICursoDAO;
import com.appjpa.jpa.dao.IModalidadDAO;
import com.appjpa.jpa.dao.IRolesDAO;
import com.appjpa.jpa.dao.ITurnoDAO;

@Component
public class DataInitializer implements ApplicationRunner {

    public boolean flag = false;

    @Autowired
    private ICarreraDAO carreraDAO;

    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private ITurnoDAO turnoDAO;

    @Autowired
    private IModalidadDAO modalidadDAO;

    @Autowired
    private IRolesDAO rolesDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Crear las tres carreras de Banca y Negocio
        Carrera carrera1 = new Carrera(null, "Banca y Negocio 1", null, null);
        Carrera carrera2 = new Carrera(null, "Estadística 1", null, null);
        Carrera carrera3 = new Carrera(null, "Inglés 1", null, null);

        // Guardar las carreras en la base de datos
        carreraDAO.guardarCar(carrera1);
        carreraDAO.guardarCar(carrera2);
        carreraDAO.guardarCar(carrera3);

        // Crear Turnos
        Turno turno1 = new Turno(null, "Mañana", null);
        Turno turno2 = new Turno(null, "Tarde", null);
        Turno turno3 = new Turno(null, "Noche", null);

        // Guardar Turnos
        turnoDAO.guardarTurno(turno1);
        turnoDAO.guardarTurno(turno2);
        turnoDAO.guardarTurno(turno3);

        // Crar Modalidades
        Modalidad modalidad1 = new Modalidad(null, "Presencial", null);
        Modalidad modalidad2 = new Modalidad(null, "Virtual", null);
        Modalidad modalidad3 = new Modalidad(null, "Semi-presencial", null);

        // Guardar Modalidades
        modalidadDAO.guardarMod(modalidad1);
        modalidadDAO.guardarMod(modalidad2);
        modalidadDAO.guardarMod(modalidad3);

        // Crear Roles
        Roles roles1 = new Roles(null, "Admin", null);
        Roles roles2 = new Roles(null, "Estudiante", null);
        Roles roles3 = new Roles(null, "General", null);

        // Guardar Roles
        rolesDAO.guardarRol(roles1);
        rolesDAO.guardarRol(roles2);
        rolesDAO.guardarRol(roles3);

        // Crear los tres cursos para cada carrera
        for (Carrera carrera : Arrays.asList(carrera1, carrera2, carrera3)) {
            Curso curso1 = new Curso(null, "Curso 1 de " + carrera.getCarrera(), "9:30", "11:30", "1", 1, null,
                    carrera);
            Curso curso2 = new Curso(null, "Curso 2 de " + carrera.getCarrera(), "11:30", "1:00", "2", 2, null,
                    carrera);
            Curso curso3 = new Curso(null, "Curso 3 de " + carrera.getCarrera(), "1:00", "1:55", "3", 3, null,
                    carrera);

            // Guardar los cursos en la base de datos
            cursoDAO.guardarCur(curso1);
            cursoDAO.guardarCur(curso2);
            cursoDAO.guardarCur(curso3);
        }
    }
}
