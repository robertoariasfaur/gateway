package com.rafaur.gateway.gateway.mapp;

import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.entity.Peripheral;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PeripheralMapperImplement implements PeripheralMapper {
    GatewayMapperImplement mapper =  new GatewayMapperImplement();
    @Override
    public Peripheral mapOtoI(PeripheralDTO peripheralDTO) {

        if (peripheralDTO == null) return null;

        Peripheral peripheral = new Peripheral();

        peripheral.setStatus(peripheralDTO.getStatus());
        peripheral.setCreated(peripheralDTO.getCreated());
        peripheral.setVendor(peripheralDTO.getVendor());
        peripheral.setUid(peripheralDTO.getUid());
        peripheral.setGateway( mapper.mapOtoI(peripheralDTO.getGateway()));
        return peripheral;
    }

    @Override
    public PeripheralDTO mapItoO(Peripheral peripheral) {
        if (peripheral == null) return null;
        PeripheralDTO peripheralDTO = new PeripheralDTO();
        peripheralDTO.setStatus(peripheral.getStatus());
        peripheralDTO.setCreated(peripheral.getCreated());
        peripheralDTO.setVendor(peripheral.getVendor());
        peripheralDTO.setUid(peripheral.getUid());
        peripheralDTO.setGateway(mapper.mapItoO(peripheral.getGateway()));
        return peripheralDTO;
    }

        public Set<PeripheralDTO> toDTOList(Set<Peripheral> peripheralList) {
        if (peripheralList == null) {
            return new HashSet<>();
        }
        return (Set<PeripheralDTO>) peripheralList.stream().map(this::mapItoO).collect(Collectors.toList());
    }
}
