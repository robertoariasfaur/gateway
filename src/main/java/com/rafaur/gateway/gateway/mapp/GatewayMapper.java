package com.rafaur.gateway.gateway.mapp;
import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.entity.Gateway;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * Mapper to transform {@link Gateway} <> {@link GatewayDTO}
 */
@Mapper(componentModel = "spring")
public interface GatewayMapper {


    /**
     * Instance of the interface implementation
     */
//    static final GatewayMapper INSTANCE = Mappers.getMapper(GatewayMapper.class);

    /**
     * mapper of {@link Gateway} To {@link GatewayDTO}
     *
     * @param gatewayDTO {@link GatewayDTO}
     * @return {@link Gateway}
     */

//    @Mapping(target = "name", expression = "java(gatewayDTO.getName())")
//    @Mapping(target = "ipv4Address", expression = "java(gatewayDTO.getIpv4Address())")
//    @Mapping(target = "serialNumber", expression = "java(gatewayDTO.getSerialNumber())")
//    @Mapping(target = "peripherals", expression = "java(java.util.Arrays.asList())")
    public Gateway mapOtoI(GatewayDTO gatewayDTO);//defaultExpression = "java(java.util.UUID.randomUUID().toString())"


    /**
     * To entity mapping
     *
     * @param gateway {@link Gateway}
     * @return {@link GatewayDTO}
     */
//    @Mapping(target = "name", expression = "java(gateway.getName())")
//    @Mapping(target = "ipv4Address", expression = "java(gateway.getIpv4Address())")
//    @Mapping(target = "serialNumber", expression = "java(gateway.getSerialNumber())")
//    @Mapping(target = "peripherals", expression = "java(java.util.Arrays.asList())")
    public GatewayDTO mapItoO(Gateway gateway);



    /**
     * Join first with last name as one String
     *
     * @param name the firstName and the lastName
     * @return the first last name as one
     */
//    default String nameConverter(String... name) {
//        return Stream.of(name).collect(Collectors.joining(" "));
//    }
//    @Override
//    public GatewayDTO mapOtoI(Gateway in) {
//        GatewayDTO gatewayDTO = new GatewayDTO();
//        gatewayDTO.setSerialNumber(in.getSerialNumber());
//        gatewayDTO.setName(in.getName());
//        gatewayDTO.setIpv4Address(in.getIpv4Address());
//
//        Iterator<Peripheral> iterator= in.getPeripherals().iterator();
//
//        while (iterator.hasNext()){
//            Peripheral peripheral = iterator.next();
//            PeripheralDTO peripheralDTO = new PeripheralDTO();
//
//            peripheralDTO.setCreated(peripheral.getCreated());
//            peripheralDTO.setUid(peripheral.getUid());
//            peripheralDTO.setStatus(peripheral.getStatus());
//            peripheralDTO.setVendor(peripheral.getVendor());
//
////            peripheralDTO.setGateway(gatewayDTO);
//
//            gatewayDTO.getPeripherals().add(peripheralDTO);
//
//        }
//
//        return gatewayDTO;
//    }
//
//    @Override
//    public Gateway mapItoO(GatewayDTO in) {
//        Gateway gateway = new Gateway();
//        gateway.setName(in.getName());
//        gateway.setSerialNumber(in.getSerialNumber());
//        gateway.setIpv4Address(in.getIpv4Address());
//
//        Iterator<PeripheralDTO> dtoIterator= in.getPeripherals().iterator();
//
//        while (dtoIterator.hasNext()){
//            PeripheralDTO peripheralDTO= dtoIterator.next();
//            Peripheral peripheral = new Peripheral();
//
//            peripheral.setUid(peripheralDTO.getUid());
//            peripheral.setStatus(peripheralDTO.getStatus());
//            peripheral.setCreated(peripheralDTO.getCreated());
//            peripheral.setVendor(peripheralDTO.getVendor());
//
//            peripheral.setGateway(gateway);
//
//            gateway.addP(peripheral);
//        }
//
//
//        return gateway;
//    }
}
