package com.BusFare.dao;

import com.BusFare.domain.Monedero;
import com.BusFare.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonederoDao extends JpaRepository<Monedero, Long> {

    Monedero findByUsuario(Usuario usuario);
}
