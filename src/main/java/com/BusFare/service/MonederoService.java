package com.BusFare.service;

import com.BusFare.domain.Monedero;
import com.BusFare.domain.Usuario;

public interface MonederoService {

    Monedero obtenerMonederoPorUsuario(Usuario usuario);

    void recargarMonedero(Usuario usuario, double monto);

    void guardarMonedero(Monedero monedero);

    public Monedero obtenerMonederoPorUsuarioId(Long idUsuario);
}
