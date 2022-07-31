package com.portfolio.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ExperienciaLaboral {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExpL;
    private String descripcionExpL;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreExpL, String descripcionExpL) {
        this.nombreExpL = nombreExpL;
        this.descripcionExpL = descripcionExpL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    