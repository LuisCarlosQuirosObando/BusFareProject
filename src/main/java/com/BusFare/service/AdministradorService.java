package com.BusFare.service;

import com.BusFare.domain.Administrador;
import java.util.List;

public interface AdministradorService {

    boolean validarCredenciales(String usuario, String contrasena);

    void guardarUsuario(Administrador usuario);

    void desactivarUsuario(Administrador usuario);

    Administrador findByUsuario(String usuario);

    public List<Administrador> getAdministradores(boolean activos);

    public Administrador getAdministrador(Administrador administrador);

    public void save(Administrador administrador);

    public void delete(Administrador administrador);
}
