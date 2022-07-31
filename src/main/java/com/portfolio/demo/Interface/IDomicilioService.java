
package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.Domicilio;
import java.util.List;


public interface IDomicilioService  {
    public List<Domicilio> getDomicilio();
    
    public void saveDomicilio(Domicilio domicilio);
    
    public void deleteDomicilio(Long id);
    
    public Domicilio findDomicilio(Long id);
    
    
}
