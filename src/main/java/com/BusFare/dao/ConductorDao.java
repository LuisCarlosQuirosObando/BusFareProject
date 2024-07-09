
package com.BusFare.dao;

import com.BusFare.domain.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorDao extends JpaRepository<Conductor, Long> {
}


