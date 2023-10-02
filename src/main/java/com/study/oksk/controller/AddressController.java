package com.study.oksk.controller;
import com.study.oksk.dto.AddressDto;
import com.study.oksk.entity.AddressEntity;
import com.study.oksk.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
@RestController // TODO:  REST --> ENDPOINTS что это
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        List<AddressDto> addressDto = addressService.findAll();
        if(!addressDto.isEmpty()){
            return ResponseEntity.ok(addressDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No addresses, try later");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        AddressDto addressDto = addressService.findById(id);
        if(addressDto != null){
            return ResponseEntity.ok(addressDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No address with such id: " + id);
        }
    }

    @PostMapping()
    public ResponseEntity<String> createAddress(@RequestBody AddressDto addressDto){
        try{
            int id = addressService.save(addressDto);
            return ResponseEntity.ok("Address created successfully, id: " + id);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something go wrong, try again later");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        AddressDto addressDto = addressService.findById(id);
        if(addressDto != null){
            addressService.deleteById(id);
            return ResponseEntity.ok("Address - '"+addressDto.getAddress()+":"+addressDto.getPort()+"' deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No address with such id: " + id);
        }
    }

    //TODO: Добавить update
    @PutMapping()
    public ResponseEntity<String> updateAddress(@RequestBody AddressDto updatedAddressDto) {
        AddressDto existingAddressDto = addressService.findById(updatedAddressDto.getId());
        if (existingAddressDto != null) {
            existingAddressDto.setAddress(updatedAddressDto.getAddress());
            existingAddressDto.setPort(updatedAddressDto.getPort());
            try {
                addressService.update(existingAddressDto);
                return ResponseEntity.ok("Address with ID: " + updatedAddressDto.getId() + " updated successfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the address");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No address found with ID: " + updatedAddressDto.getId());
        }
    }
}











