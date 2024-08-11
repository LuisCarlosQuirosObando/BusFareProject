package com.BusFare.dao;

import com.BusFare.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByActivoTrue();
}
