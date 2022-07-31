/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoProyectos;
import com.portfolio.demo.Entity.Proyectos;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.ProyectosS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosC {
     @Autowired
    ProyectosS Proyectoss;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
    List<Proyectos> list = Proyectoss.list();
    return new ResponseEntity(list, HttpStatus.OK);
    
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!Proyectoss.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
       Proyectos proyectos = Proyectoss.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!Proyectoss.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Proyectoss.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminado"), HttpStatus.OK);
        
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombredeP())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (Proyectoss.existsByNombredeP(dtoproyectos.getNombredeP())) {
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombredeP(), dtoproyectos.getDescripcionP(), dtoproyectos.getImgP());

        Proyectoss.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        if (!Proyectoss.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (Proyectoss.existsByNombredeP(dtoproyectos.getNombredeP()) && Proyectoss.getByNombredeP(dtoproyectos.getNombredeP()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyectos.getNombredeP())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = Proyectoss.getOne(id).get();

        proyectos.setNombredeP(dtoproyectos.getNombredeP());
        proyectos.setDescripcionP(dtoproyectos.getDescripcionP());
        proyectos.setImgP((dtoproyectos.getImgP()));

        Proyectoss.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    } 
}
