package com.rafaur.gateway.gateway.mapp;

import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.entity.Gateway;

public class GatewayMapperImplement implements GatewayMapper{

    private PeripheralMapperImplement mapper = new PeripheralMapperImplement();


    @Override
    public Gateway mapOtoI(GatewayDTO gatewayDTO) {
        if(gatewayDTO == null)
            return null;

        Gateway g = new Gateway();
        g.setName(gatewayDTO.getName());
        g.setSerialNumber(gatewayDTO.getSerialNumber());
        g.setIpv4Address(gatewayDTO.getIpv4Address());


        return g;

    }

    @Override
    public GatewayDTO mapItoO(Gateway gateway) {
        if(gateway == null)
            return null;

        GatewayDTO g = new GatewayDTO();
        g.setName(gateway.getName());
        g.setSerialNumber(gateway.getSerialNumber());
        g.setIpv4Address(gateway.getIpv4Address());

//        g.setPeripherals(mapper.toDTOList(gateway.getPeripherals()));


        return g;

    }
}
