package com.study.oksk.controller;

import com.study.oksk.dto.AddressDto;
import com.study.oksk.service.AddressService;
import com.study.oksk.transfer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // TODO:  REST --> ENDPOINTS что это
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public ResponseEntity<List<AddressDto>> findAll(){
        try {
            return ResponseEntity.ok(addressService.findAll());
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable("id") int id){
        try {
            AddressDto addressDto = addressService.findById(id);
            if (addressDto != null) {
                return ResponseEntity.ok(addressDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Integer> createAddress(@Validated(value = {New.class}) @RequestBody AddressDto addressDto){
        try{
            return ResponseEntity.ok(addressService.save(addressDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try {
            AddressDto addressDto = addressService.findById(id);
            if (addressDto != null) {
                addressService.deleteById(id);
                return ResponseEntity.ok(id);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping()
    public ResponseEntity<Integer> updateAddress(@Validated(value = Update.class) @RequestBody AddressDto updatedAddressDto) {
        try {
            AddressDto existingAddressDto = addressService.findById(updatedAddressDto.getId());
            if (existingAddressDto != null) {
                existingAddressDto.setAddress(updatedAddressDto.getAddress());
                existingAddressDto.setPort(updatedAddressDto.getPort());
                return ResponseEntity.ok(addressService.save(existingAddressDto));
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}











