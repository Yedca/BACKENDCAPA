package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoExperienciaLaboral;
import com.portfolio.demo.Entity.ExperienciaLaboral;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.SExperienciaLab;
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
@RequestMapping("/expelab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralC {
    @Autowired
    SExperienciaLab sExperienciaLab;
   
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
     List<ExperienciaLaboral> list = sExperienciaLab.list();
     return new ResponseEntity(list, HttpStatus.OK );
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id) {
        if (!sExperienciaLab.existsById(id)) 
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        ExperienciaLaboral experienciaLaboral = sExperienciaLab.getOne(id).get();
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperienciaLab.existsById(id)){ 
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }  
        sExperienciaLab.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperienciaLaboral dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreExpL())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }    
        if(sExperienciaLab.existsByNombreExpL(dtoexp.getNombreExpL())){
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    }
    ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoexp.getNombreExpL(), dtoexp.getDescripcionExpL());
    sExperienciaLab.save(experienciaLaboral);
    
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperienciaLaboral dtoexp){
        if(!sExperienciaLab.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sExperienciaLab.existsByNombreExpL(dtoexp.getNombreExpL()) && sExperienciaLab.getByNombreExpL(dtoexp.getNombreExpL()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoexp.getNombreExpL())){
            return new ResponseEntity(new Mensaje("El nombre es obligartorio"), HttpStatus.BAD_REQUEST);
        }

       ExperienciaLaboral experienciaLaboral = sExperienciaLab.getOne(id).get();
       
       experienciaLaboral.setNombreExpL(dtoexp.getNombreExpL());
       experienciaLaboral.setDescripcionExpL(dtoexp.getDescripcionExpL());
       
       sExperienciaLab.save(experienciaLaboral);
       
       return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }  
    
}
    
    
    
