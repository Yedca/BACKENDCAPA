
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.ExperienciaLaboral;
import com.portfolio.demo.Repository.RExperienciaLab;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperienciaLab {
    @Autowired
    RExperienciaLab rExperienciaLab;
    
    public List<ExperienciaLaboral> list(){
      return  rExperienciaLab.findAll();
    }
    
    public Optional<ExperienciaLaboral> getOne(int id){
       return rExperienciaLab.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByNombreExpL(String nombreExpL){
        return rExperienciaLab.findByNombreExpL(nombreExpL);
        
    }
    
    public void save(ExperienciaLaboral expelab){
     rExperienciaLab.save(expelab);
    }
    
    public void delete(int id){
        rExperienciaLab.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperienciaLab.existsById(id);
        
    }
    
    public boolean existsByNombreExpL(String nombreExpL){
        return rExperienciaLab.existsByNombreExpL(nombreExpL);
    }
}

