
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Domicilio;
import com.portfolio.demo.Interface.IDomicilioService;
import com.portfolio.demo.Repository.IDomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpDomicilioRepository implements IDomicilioService {
    @Autowired IDomicilioRepository idomicilioRepository;

    @Override
    public List<Domicilio> getDomicilio() {
    List<Domicilio> domicilio = idomicilioRepository.findAll();
    return domicilio;
    }

    @Override
    public void saveDomicilio(Domicilio domicilio) {
     idomicilioRepository.save(domicilio);
     
     }
    @Override
    public void deleteDomicilio(Long id) {
    idomicilioRepository.deleteById(id);
            }
    @Override
    public Domicilio findDomicilio(Long id) {
    Domicilio domicilio = idomicilioRepository.findById(id).orElse(null);
    return domicilio;
    }
    
    
}
