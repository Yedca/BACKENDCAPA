/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Proyectos;
import com.portfolio.demo.Repository.ProyectosR;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosS {
     @Autowired
    ProyectosR Proyectosr;
    
    public List<Proyectos> list(){
        return Proyectosr.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return Proyectosr.findById(id);
    }
    
    public Optional<Proyectos> getByNombredeP(String nombredeP){
        return Proyectosr.findByNombredeP(nombredeP);
        
    }
    
    public void save(Proyectos proyectos){
        Proyectosr.save(proyectos);
    }
    
    public void delete(int id){
        Proyectosr.deleteById(id);
    }
    
    public boolean existsById(int id){
        return Proyectosr.existsById(id);
    }
    
    public boolean existsByNombredeP(String nombredeP){
        return Proyectosr.existsByNombredeP(nombredeP);
    }
    
}


