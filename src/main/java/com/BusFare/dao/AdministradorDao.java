package com.BusFare.dao;

import com.BusFare.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorDao extends JpaRepository<Administrador, Long> {
    
    Administrador findByUsuario(String usuario);
    
}
