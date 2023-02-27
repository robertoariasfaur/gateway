package com.rafaur.gateway.gateway.Repository;

import com.rafaur.gateway.gateway.entity.Peripheral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeripheralRepository extends JpaRepository<Peripheral, Long> {
}
