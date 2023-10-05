package com.study.oksk.controller;

import com.study.oksk.dto.AddressCreateDto;
import com.study.oksk.dto.AddressDto;
import com.study.oksk.dto.AddressUpdateDto;
import com.study.oksk.service.AddressService;
import com.study.oksk.transfer.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@Validated
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
    public ResponseEntity<Integer> createAddress(@RequestBody @Validated AddressCreateDto addressCreateDto){
        try{
            return ResponseEntity.ok(addressService.create(addressCreateDto));
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
    public ResponseEntity<Integer> updateAddress(@RequestBody AddressUpdateDto addressUpdateDto) {
        try {
            if (addressService.findById(addressUpdateDto.getId()) != null) {
                return ResponseEntity.ok(addressService.save(addressUpdateDto));
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}

