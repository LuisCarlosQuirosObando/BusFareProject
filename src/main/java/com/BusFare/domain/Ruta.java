
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
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private int id_ruta;

    @Column(name = "nombre_ruta")
    private String nombre_ruta;

    @Column(name = "provincia")
    private String provincia;
    
    @Column(name = "cantidad_estaciones")
    private int cantidad_estaciones;

    @Column(name = "activo")
    private boolean activo;

    // Getters y setters

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCantidad_estaciones() {
        return cantidad_estaciones;
    }

    public void setCantidad_estaciones(int cantidad_estaciones) {
        this.cantidad_estaciones = cantidad_estaciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}    
