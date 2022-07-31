
package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
 @Id
 @GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String nombredeP;
private String descripcionP;
private String imgP;

    public Proyectos() {
    }

    public Proyectos(String nombredeP, String descripcionP, String imgP) {
        this.nombredeP = nombredeP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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