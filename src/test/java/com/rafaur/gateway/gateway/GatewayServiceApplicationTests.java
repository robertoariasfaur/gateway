package com.rafaur.gateway.gateway;

import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.entity.Peripheral;
import com.rafaur.gateway.gateway.mapp.GatewayMapper;
import com.rafaur.gateway.gateway.mapp.GatewayMapperImplement;
import com.rafaur.gateway.gateway.entity.Gateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest(classes = {GatewayMapperImplement.class })
class GatewayServiceApplicationTests {

	private GatewayMapperImplement mapper = new GatewayMapperImplement();
	@Test
	void contextLoads() {
	}

	@Test
	public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
		GatewayDTO dto = new GatewayDTO();
		dto.setSerialNumber(UUID.randomUUID().toString());
		dto.setName("John");
		dto.setIpv4Address("192.168.1.1");

		//////////////////////////////////////////////////
		PeripheralDTO peripheralDTO = new PeripheralDTO();
		peripheralDTO.setVendor("Domain Driver Design");

		peripheralDTO.setUid( 0L);
		peripheralDTO.setCreated(new Date(System.currentTimeMillis()));
		peripheralDTO.setStatus(true);
		peripheralDTO.setGateway(dto);

		//////////////////////////////////////////////////////////
		PeripheralDTO peripheral1= new PeripheralDTO();
		peripheral1.setVendor("J2EE Development without EJB");
		peripheral1.setUid(1L);

		peripheral1.setCreated(new Date(System.currentTimeMillis()));
		peripheral1.setStatus(true);
		peripheral1.setGateway(dto);

		dto.getPeripherals().add(peripheralDTO);
		dto.getPeripherals().add(peripheral1);

		Gateway entity = mapper.mapOtoI(dto);

		Assertions.assertEquals(dto.getSerialNumber(), entity.getSerialNumber());
		Assertions.assertEquals(dto.getName(), entity.getName());

		Assertions.assertEquals(dto.getIpv4Address(), entity.getIpv4Address());

		Assertions.assertEquals(dto.getPeripherals().size(),2);

	}



}
