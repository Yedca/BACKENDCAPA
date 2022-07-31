package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
   public List<Educacion> getEducacion();
   
   public void saveEducacion(Educacion educacion);
   
   public void deleteEducacion(Long id);
   
   public Educacion findEducacion(Long id);
   
}
