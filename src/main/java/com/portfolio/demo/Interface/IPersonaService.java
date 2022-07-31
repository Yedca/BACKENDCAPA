package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.Persona;
import java.util.List;


public interface IPersonaService {
//Traer una lista de persona
public List<Persona> getPersona();

//Guarda un objeto de tipo persona//
public void savePersona(Persona persona);

//Eliminar un objeto pero lo buscamos por ID//
public void deletePersona(Long id);

//Buscamos una persona//
public Persona findPersona(Long id);
}
