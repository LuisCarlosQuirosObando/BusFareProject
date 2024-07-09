package com.BusFare.service;

import com.BusFare.dao.ClienteDao;
import com.BusFare.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;

    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
     public void eliminarCliente(Long id) {
        clienteDao.deleteById(id);
    }
}
