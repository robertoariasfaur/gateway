package com.rafaur.gateway.gateway.controller;

import com.rafaur.gateway.gateway.dto.PeripheralDTO;
import com.rafaur.gateway.gateway.entity.Peripheral;
import com.rafaur.gateway.gateway.service.PeripheralService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/peripheral")
//@Validated
public class PeripheralController {
    @Autowired
   private  PeripheralService repository;

    @GetMapping
    public ResponseEntity<Iterable<PeripheralDTO>> getPeripheryList() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createPeripheral(@Valid @RequestBody PeripheralDTO peripheral) {
        try {
            repository.createPeripheral(peripheral);
            return new ResponseEntity<String>("", HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }


//    @PutMapping
//    public ResponseEntity<String> updatePeripheral(@RequestBody Peripheral peripheral) {
//        try {
//            if (!repository.existsById(peripheral.getUid()))
//                throw new Exception("El peripheral no existe en el sistema");
//            else {
//                repository.save(peripheral);
//                return new ResponseEntity<String>("", HttpStatus.OK);
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
//
//        }
//    }
}
