package com.BusFare.service.impl;
import com.BusFare.dao.AdministradorDao;
import com.BusFare.domain.Administrador;
import com.BusFare.service.AdministradorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdministradorServiceImpl implements AdministradorService {
    
    @Autowired
    private AdministradorDao administradorDao;
    
     @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        Administrador user = administradorDao.findByUsuario(usuario);

        if (user != null && user.isActivo()) {
            if (user.getContrasena().equals(contrasena)) {
                administradorDao.save(user);
                return true;
            } 
        }
        return false;
    }

    @Override
    public void guardarUsuario(Administrador usuario) {
        administradorDao.save(usuario);
    }

    

    @Override
    public void desactivarUsuario(Administrador usuario) {
        usuario.setActivo(false);
        administradorDao.save(usuario);
    }

    @Override
    public Administrador findByUsuario(String usuario) {
        return administradorDao.findByUsuario(usuario);
    }

    
    
    
    
}
