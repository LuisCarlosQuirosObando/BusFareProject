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
        
        if (user != null && user.getContrasena().equals(contrasena)) {
            return true;
        }
        
        return false;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }
}
