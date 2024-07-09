
package com.BusFare.dao;

import com.BusFare.domain.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaDao extends JpaRepository<Ruta, Long> {
}


