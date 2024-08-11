package com.BusFare.service;
import com.BusFare.domain.Administrador;

public interface AdministradorService {
     boolean validarCredenciales(String usuario, String contrasena);
     void guardarUsuario(Administrador usuario);   
     void desactivarUsuario(Administrador usuario);
     Administrador findByUsuario(String usuario);
    
}
