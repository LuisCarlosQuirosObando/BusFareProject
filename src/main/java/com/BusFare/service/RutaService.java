package com.BusFare.service;

import com.BusFare.dao.RutaDao;
import com.BusFare.domain.Ruta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaService {

    @Autowired
    private RutaDao rutaDao;

    public List<Ruta> findAll() {
        return rutaDao.findAll();
    }

    public Ruta findById(Long id) {
        return rutaDao.findById(id).orElse(null);
    }

    public void save(Ruta ruta) {
        rutaDao.save(ruta);
    }

    public void eliminarRuta(Long id) {
        rutaDao.deleteById(id);
    }
}
