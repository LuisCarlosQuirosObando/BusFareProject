package com.BusFare.service;
import com.BusFare.domain.Usuario;

public interface UsuarioService {
     boolean validarCredenciales(String usuario, String contrasena);
     void guardarUsuario(Usuario usuario);
}
