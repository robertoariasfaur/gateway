package com.rafaur.gateway.gateway.service;

import com.rafaur.gateway.gateway.Repository.PeripheralRepository;
import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.mapp.GatewayMapperImplement;
import com.rafaur.gateway.gateway.mapp.PeripheralMapper;
import com.rafaur.gateway.gateway.entity.Peripheral;
import com.rafaur.gateway.gateway.mapp.PeripheralMapperImplement;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class PeripheralService {
    private final PeripheralRepository repository;

    private final PeripheralMapper mapper = new PeripheralMapperImplement();

    public PeripheralService(PeripheralRepository repository) {
        this.repository = repository;
    }


    public Peripheral createPeripheral(PeripheralDTO peripheralDTO) {
        return this.repository.save(mapper.mapOtoI(peripheralDTO));
    }
    public Peripheral createPeripheral(Peripheral peripheral) {
        return this.repository.save(peripheral);
    }

    public Set<PeripheralDTO> findAll() {
        Iterable<Peripheral> peripherals =
                this.repository.findAll();

        Set<PeripheralDTO> peripheralDTOS = new HashSet<>();

        peripherals.forEach(peripheral -> peripheralDTOS.add(mapper.mapItoO(peripheral)));

        return peripheralDTOS ;
    }

}
