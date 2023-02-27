package com.rafaur.gateway.gateway.Repository;

import com.rafaur.gateway.gateway.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, String> {
}
