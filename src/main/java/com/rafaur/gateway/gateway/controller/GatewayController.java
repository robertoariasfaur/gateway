package com.rafaur.gateway.gateway.controller;

import com.rafaur.gateway.gateway.dto.GatewayDTO;
import com.rafaur.gateway.gateway.entity.Gateway;
import com.rafaur.gateway.gateway.service.GatewayService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/gateways")
@AllArgsConstructor
//@Validated
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @PostMapping
    public ResponseEntity<String> createGateway(@Valid @RequestBody GatewayDTO gateway){
        try {
            return new ResponseEntity<String>(this.gatewayService.
                    createGateway(gateway).getSerialNumber(),
                    HttpStatus.CREATED);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_MODIFIED);
        }
    }


    @PutMapping
    public ResponseEntity<String> updateGateway(@Valid @RequestBody GatewayDTO gateway){
//        try {
                this.gatewayService.updateGateway(gateway);
                return new ResponseEntity<String>("", HttpStatus.OK);

//        }catch (Exception e){
//            System.err.println(e.getMessage());
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_MODIFIED);
//        }

    }



    @GetMapping(value = "/getGateways")
    public ResponseEntity<Set<GatewayDTO>> getGateways(){
        var resp = this.gatewayService.findAll();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @GetMapping(value = "/getGateway/{serialNumber}")
    public ResponseEntity<GatewayDTO> getGateway(@PathVariable(
            value = "serialNumber", required = true) String serialNumber) {
        return new ResponseEntity<>(this.gatewayService.findById(serialNumber), HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteGateway/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteGateway(@PathVariable(
            value = "serialNumber", required = true) String serialNumber){
        this.gatewayService.deleteById(serialNumber);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/deleteGateways")
    public ResponseEntity<String> deleteGateways(){
        try {
                this.gatewayService.deleteAllGateways();

                return new ResponseEntity<String>("", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
