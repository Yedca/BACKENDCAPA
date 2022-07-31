
package com.portfolio.demo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
    @NotBlank
    private String nombredeP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imgP;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombredeP, String descripcionP, String imgP) {
        this.nombredeP = nombredeP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }

    public String getNombredeP() {
        return nombredeP;
    }

    public void setNombredeP(String nombredeP) {
        this.nombredeP = nombredeP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    
}
