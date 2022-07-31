
package com.portfolio.demo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperienciaLaboral {
    @NotBlank
   private String nombreExpL;
    @NotBlank
   private String descripcionExpL;

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombreExpL, String descripcionExpL) {
        this.nombreExpL = nombreExpL;
        this.descripcionExpL = descripcionExpL;
    }

    public String getNombreExpL() {
        return nombreExpL;
    }

    public void setNombreExpL(String nombreExpL) {
        this.nombreExpL = nombreExpL;
    }

    public String getDescripcionExpL() {
        return descripcionExpL;
    }

    public void setDescripcionExpL(String descripcionExpL) {
        this.descripcionExpL = descripcionExpL;
    }

  
    
    
}
