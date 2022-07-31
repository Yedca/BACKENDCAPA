
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosR extends JpaRepository<Proyectos, Integer>{
      public Optional<Proyectos> findByNombredeP(String nombredeP);
    public boolean existsByNombredeP(String NombredeP);
    
}
