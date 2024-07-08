package com.BusFare.service.impl;

import com.BusFare.dao.UsuarioDao;
import com.BusFare.domain.Usuario;
import com.BusFare.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        Usuario user = usuarioDao.findByUsuario(usuario);

        if (user != null && user.isActivo()) {
            if (user.getContrasena().equals(contrasena)) {
                user.setIntentosFallidos(0);
                usuarioDao.save(user);
                return true;
            } else {
                incrementarIntentosFallidos(user);
            }
        }
        return false;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void incrementarIntentosFallidos(Usuario usuario) {
        usuario.setIntentosFallidos(usuario.getIntentosFallidos() + 1);
        if (usuario.getIntentosFallidos() >= 3) {
            usuario.setActivo(false);
        }
        usuarioDao.save(usuario);
    }

    @Override
    public void desactivarUsuario(Usuario usuario) {
        usuario.setActivo(false);
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioDao.findByUsuario(usuario);
    }
}
