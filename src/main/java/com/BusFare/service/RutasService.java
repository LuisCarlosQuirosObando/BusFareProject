
package com.BusFare.service;

import com.BusFare.dao.RutasDao;
import com.BusFare.domain.Rutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasService {
    @Autowired
    private RutasDao rutasDao;

    public List<Rutas> getAllRutas() {
        return rutasDao.findAll();
    }
}
