package com.rafaur.gateway.gateway.service;

import com.rafaur.gateway.gateway.Repository.GatewayRepository;
import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.mapp.GatewayMapper;
import com.rafaur.gateway.gateway.entity.Gateway;
import com.rafaur.gateway.gateway.mapp.GatewayMapperImplement;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@NoArgsConstructor
public class GatewayService {
    @Autowired
    private GatewayRepository gatewayRepository;

//    @Autowired
//    private final PeripheralRepository  pRepository;
    private GatewayMapperImplement mapper = new GatewayMapperImplement();

    public GatewayService(GatewayRepository gatewayRepository){
        this.gatewayRepository=gatewayRepository;
    }



    public Gateway createGateway(GatewayDTO gatewayDTO) {
        Gateway gateway = mapper.mapOtoI(gatewayDTO);
        return this.createGateway(gateway);
    }


    public Gateway createGateway(Gateway gateway) {
//        Iterator<Peripheral> peripherals = gateway.getPeripherals().iterator();
//        while (peripherals.hasNext()){
//            Peripheral p = peripherals.next();
//            pRepository.save(p);
//        }

        return this.gatewayRepository.save(gateway);
    }

    public Set<GatewayDTO> findAll() {
        Iterator<Gateway> gateways =
                this.gatewayRepository.findAll().stream().iterator();

        Set<GatewayDTO> gatewayDTOS = new HashSet<>();

        while (gateways.hasNext()){
            Gateway gateway1 = gateways.next();
            gatewayDTOS.add(mapper.mapItoO(gateway1));
        }

        return gatewayDTOS ;
    }

    public GatewayDTO findById(String serialNumber) {
        Optional<Gateway> optionalTask =
                this.gatewayRepository.findById(serialNumber);
        if (optionalTask.isPresent()) {
            return mapper.mapItoO(optionalTask.get());
        }
        throw new InvalidMediaTypeException
                ("Gateway not found", HttpStatus.NOT_FOUND.name());
    }

    @Transactional
    public Gateway updateGateway(GatewayDTO gatewayDTO) {
        Gateway gateway = mapper.mapOtoI(gatewayDTO);
        if (!this.gatewayRepository.existsById(gateway.getSerialNumber())) {
            throw new org.springframework.http.InvalidMediaTypeException
                    ("Gateway dont exist", HttpStatus.NOT_FOUND.name());
        }
        return this.gatewayRepository.save(gateway);
    }

    public void deleteById(String id) {
        Optional<Gateway> optional =
                this.gatewayRepository.findById(id);
        if (!optional.isPresent()) {
            throw new org.springframework.http.InvalidMediaTypeException
                    ("Gateway not found", HttpStatus.NOT_FOUND.name());
        }
        this.gatewayRepository.deleteById(id);
    }


    public void deleteAllGateways() {
        this.gatewayRepository.deleteAll();
    }



}
