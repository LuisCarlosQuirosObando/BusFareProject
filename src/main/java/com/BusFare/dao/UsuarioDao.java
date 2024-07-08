package com.BusFare.dao;
import com.BusFare.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsuario(String usuario);
}