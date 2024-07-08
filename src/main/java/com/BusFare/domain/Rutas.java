
package com.BusFare.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rutas")

public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    
    private Long idRuta;
    private String nombreRuta;
    private String provincia;
    private int cantidadEstaciones;
    private boolean activo;

    public Rutas() {
    }

    public Rutas(String nombreRuta, String provincia, int cantidadEstaciones, boolean activo) {
        this.nombreRuta = nombreRuta;
        this.provincia = provincia;
        this.cantidadEstaciones = cantidadEstaciones;
        this.activo = activo;
    }

    
    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCantidadEstaciones() {
        return cantidadEstaciones;
    }

    public void setCantidadEstaciones(int cantidadEstaciones) {
        this.cantidadEstaciones = cantidadEstaciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}