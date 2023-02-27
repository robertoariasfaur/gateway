package com.rafaur.gateway.gateway.mapp;

import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.entity.Peripheral;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//public class PeripheralMapper implements IMaper<PeripheralDTO, Peripheral>{
@Mapper(componentModel = "spring")
public interface PeripheralMapper {
    /**
     * Instance of the interface implementation
     */
//    static final PeripheralMapper INSTANCE = Mappers.getMapper(PeripheralMapper.class);


//    @Mapping(target = "uid", expression = "java(peripheralDTO.getUid())")
//    @Mapping(target = "vendor", expression = "java(peripheralDTO.getVendor())")
//    @Mapping(target = "created", expression = "java(peripheralDTO.getCreated())")
//    @Mapping(target = "status", expression = "java(peripheralDTO.getStatus())")
//    @Mapping(target = "gateway", expression = "java(peripheralDTO.getGateway())")

    public Peripheral mapOtoI(PeripheralDTO peripheralDTO);

//    @Mapping(target = "uid", expression = "java(peripheral.getUid())")
//    @Mapping(target = "vendor", expression = "java(peripheral.getVendor())")
//    @Mapping(target = "created", expression = "java(peripheral.getCreated())")
//    @Mapping(target = "status", expression = "java(peripheral.getStatus())")
//    @Mapping(target = "gateway", expression = "java(peripheral.getGateway())")
    public PeripheralDTO mapItoO(Peripheral peripheral);

    /**
     * To list of {@link PeripheralDTO}
     *
     * @param peripheralList {@link List<Peripheral>}
     * @return {@link List<PeripheralDTO>}
     */



//    private final GatewayMapper mapper = new GatewayMapper();
//
//    @Override
//    public Peripheral mapItoO(PeripheralDTO in) {
//        Peripheral peripheral = new Peripheral();
//
//        peripheral.setStatus(in.getStatus());
//        peripheral.setCreated(in.getCreated());
//        peripheral.setVendor(in.getVendor());
//        peripheral.setUid(in.getUid());
//        //peripheral.setGateway( mapper.mapItoO(in.getGateway()));
//        return peripheral;
//    }
//
//    @Override
//    public PeripheralDTO mapOtoI(Peripheral in) {
//        PeripheralDTO peripheral = new PeripheralDTO();
//        peripheral.setStatus(in.getStatus());
//        peripheral.setCreated(in.getCreated());
//        peripheral.setVendor(in.getVendor());
//        peripheral.setUid(in.getUid());
////        peripheral.setGateway(mapper.mapOtoI(in.getGateway()));
//        return peripheral;
//    }
}
