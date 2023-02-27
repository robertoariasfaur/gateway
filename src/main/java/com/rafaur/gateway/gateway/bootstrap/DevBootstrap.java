package com.rafaur.gateway.gateway.bootstrap;

import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.entity.Gateway;
import com.rafaur.gateway.gateway.entity.Peripheral;
import com.rafaur.gateway.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

    @Component
    public class DevBootstrap   implements ApplicationListener<ContextRefreshedEvent> {

        @Autowired
        private GatewayService service;

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {

            init();
            initDTO();
        }

        private void init(){
            //
            //
            Gateway gateway = new Gateway();
            gateway.setName("Evans");
            gateway.setIpv4Address("127.0.0.1");
            gateway.setSerialNumber(UUID.randomUUID().toString());

            //////////////////////////////////////////////////
            Peripheral peripheral = new Peripheral(gateway);
            peripheral.setVendor("Domain Driver Design");

            peripheral.setUid( 0L);
            peripheral.setCreated(new Date(System.currentTimeMillis()));
            peripheral.setStatus(true);

            //////////////////////////////////////////////////////////
            Peripheral peripheral1= new Peripheral(gateway);
            peripheral1.setVendor("J2EE Development without EJB");
            peripheral1.setUid(1L);

            peripheral1.setCreated(new Date(System.currentTimeMillis()));
            peripheral1.setStatus(true);

            gateway.getPeripherals().add(peripheral);
            gateway.getPeripherals().add(peripheral1);

            Gateway save = service.createGateway(gateway);

            System.err.println(save.getSerialNumber());

        }

        private void initDTO(){
            //
            //
            GatewayDTO gateway = new GatewayDTO();
            gateway.setName("Evans");
            gateway.setIpv4Address("127.0.0.1");
            gateway.setSerialNumber(UUID.randomUUID().toString());

            //////////////////////////////////////////////////
            PeripheralDTO peripheral = new PeripheralDTO();
            peripheral.setVendor("Domain Driver Design");

            peripheral.setUid( 2L);
            peripheral.setCreated(new Date(System.currentTimeMillis()));
            peripheral.setStatus(true);

            //////////////////////////////////////////////////////////
            PeripheralDTO peripheral1= new PeripheralDTO();
            peripheral1.setVendor("J2EE Development without EJB");
            peripheral1.setUid(3L);

            peripheral1.setCreated(new Date(System.currentTimeMillis()));
            peripheral1.setStatus(true);

            gateway.getPeripherals().add(peripheral);
            gateway.getPeripherals().add(peripheral1);

            Gateway save = service.createGateway(gateway);

            System.err.println(save.getSerialNumber());

        }
}
