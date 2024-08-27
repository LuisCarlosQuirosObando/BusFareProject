package com.BusFare.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "rutas")
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Long idRuta;
    private String nombre_ruta;
    private String provincia;
    private int cantidad_estaciones;
    private boolean activo;

    public Ruta() {
    }

    public Ruta(String nombre_ruta, String provincia, int cantidad_estaciones, boolean activo) {
        this.nombre_ruta = nombre_ruta;
        this.provincia = provincia;
        this.cantidad_estaciones = cantidad_estaciones;
        this.activo = activo;
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
