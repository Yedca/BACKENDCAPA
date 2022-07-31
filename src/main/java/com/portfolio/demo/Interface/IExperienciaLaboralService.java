package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
  //traer una lista de ExperienciaLaboral  
public List<ExperienciaLaboral> getExperienciaLaboral();

//guardar un objeto de tipo Experincia Laboral
public void saveExperienciaLaboral(ExperienciaLaboral experiencialaboral);

//eliminar una Experiencia laboral
public void deleteExperienciaLaboral(Long id);

//buscar una experiencia laboral
public ExperienciaLaboral findExperienciaLaboral(Long id);

}