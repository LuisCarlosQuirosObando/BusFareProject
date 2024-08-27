package com.BusFare.service.impl;

import com.BusFare.dao.MonederoDao;
import com.BusFare.domain.Monedero;
import com.BusFare.domain.Usuario;
import com.BusFare.service.MonederoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonederoServiceImpl implements MonederoService {

    @Autowired
    private MonederoDao monederoDao;

    @Override
    @Transactional(readOnly = true)
    public Monedero obtenerMonederoPorUsuario(Usuario usuario) {
        return monederoDao.findByUsuario(usuario);
    }

    @Override
    @Transactional
    public void recargarMonedero(Usuario usuario, double monto) {
        Monedero monedero = monederoDao.findByUsuario(usuario);
        if (monedero != null) {
            monedero.setSaldo(monedero.getSaldo() + monto);
            monederoDao.save(monedero);
        } else {
            monedero = new Monedero(usuario, monto);
            monederoDao.save(monedero);
        }
    }

    @Override
    @Transactional
    public void guardarMonedero(Monedero monedero) {
        monederoDao.save(monedero);
    }

    @Override
    public Monedero obtenerMonederoPorUsuarioId(Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
