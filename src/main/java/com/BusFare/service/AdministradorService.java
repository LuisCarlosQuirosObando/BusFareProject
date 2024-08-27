package com.BusFare.service;

import com.BusFare.domain.Administrador;
import java.util.List;

public interface AdministradorService {

    boolean validarCredenciales(String usuario, String contrasena);

    void guardarUsuario(Administrador usuario);

    void desactivarUsuario(Administrador usuario);

    Administrador findByUsuario(String usuario);
    // Se obtiene un listado de administradores en un List

    public List<Administrador> getAdministradores(boolean activos);

    // Se obtiene un Administrador, a partir del id de un administrador
    public Administrador getAdministrador(Administrador administrador);

//     Se inserta un nuevo administrador si el id del administrador esta vacío
//     Se actualiza un administrador si el id del administrador NO esta vacío
    public void save(Administrador administrador);


}
