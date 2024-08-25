package com.BusFare.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "monedero")
public class Monedero implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monedero")
    private Long idMonedero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private double saldo;

    public Monedero() {
        this.saldo = 0.0;
    }

    public Monedero(Usuario usuario, double saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public Long getIdMonedero() {
        return idMonedero;
    }

    public void setIdMonedero(Long idMonedero) {
        this.idMonedero = idMonedero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
