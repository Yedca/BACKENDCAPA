
package com.portfolio.demo.Controller;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.portfolio.demo.Entity.Domicilio;
import com.portfolio.demo.Interface.IDomicilioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomicilioController {
    @Autowired IDomicilioService idomicilioService;
    
    @GetMapping("/domicilios/traer")
    public List<Domicilio> getDomicilio(){
    return idomicilioService.getDomicilio();
       }
    
    @PostMapping("/domicilios/crear")
    public String createDomicilio(@RequestBody Domicilio domicilio){
        idomicilioService.saveDomicilio(domicilio);
        return "El Domicilio fue creado Correctamente";
    }
    
    @DeleteMapping("/domicilios/borrar/{id}")
    public String deleteDomicilio(@PathVariable Long id){
        idomicilioService.deleteDomicilio(id);
        return "El Domicilio fue eliminado correctamente";
    }
    
    @PutMapping("/domicilios/editar/{id}")
    public Domicilio editDomicilio(@PathVariable Long id,
                                    @RequestParam("nombreProvincia") String nuevoNombreProvincia,
                                    @RequestParam("nombreLocalidad") String nuevoNombreLocalidad,
                                    @RequestParam("CodigoPostal") String nuevoCodigoPostal){
    
    Domicilio domicilio = idomicilioService.findDomicilio(id);
    
    domicilio.setnombreProvincia(nuevoNombreProvincia);
    domicilio.setnombreLocalidad(nuevoNombreLocalidad);
    domicilio.setCodigoPostal(nuevoCodigoPostal);
    
    idomicilioService.saveDomicilio(domicilio);
    return domicilio;
}
    
}
