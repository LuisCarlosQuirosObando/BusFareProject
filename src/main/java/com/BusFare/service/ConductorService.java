package com.BusFare.service;

import com.BusFare.domain.Conductor;
import com.BusFare.dao.ConductorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {

    @Autowired
    private ConductorDao conductorDao;

    public List<Conductor> findAll() {
        return conductorDao.findAll();
    }

    public Conductor findById(Long id) {
        return conductorDao.findById(id).orElse(null);
    }

    public void save(Conductor conductor) {
        conductorDao.save(conductor);
    }

    public void eliminarConductor(Long id) {
        conductorDao.deleteById(id);
    }
}
