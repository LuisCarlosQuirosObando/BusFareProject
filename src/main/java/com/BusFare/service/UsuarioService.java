package com.BusFare.service;
import com.BusFare.domain.Usuario;

public interface UsuarioService {
     boolean validarCredenciales(String usuario, String contrasena);
     void guardarUsuario(Usuario usuario);
     void incrementarIntentosFallidos(Usuario usuario);
     void desactivarUsuario(Usuario usuario);
     Usuario findByUsuario(String usuario);

    public Usuario obtenerUsuarioPorId(Long usuarioId);

}
