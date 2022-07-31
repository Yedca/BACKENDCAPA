
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperienciaLab extends JpaRepository<ExperienciaLaboral, Integer> {
    public Optional<ExperienciaLaboral> findByNombreExpL(String nombreExpL);
    public boolean existsByNombreExpL(String nombreExpL);
}
