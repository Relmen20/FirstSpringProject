package com.study.oksk.controller;

import com.study.oksk.dto.ProviderCreateDto;
import com.study.oksk.dto.ProviderDto;
import com.study.oksk.dto.ProviderUpdateDto;
import com.study.oksk.entity.ProviderEntity;
import com.study.oksk.service.ProviderService;
import com.study.oksk.transfer.New;
import com.study.oksk.transfer.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/provider")
@Validated
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public ResponseEntity<List<ProviderDto>> findAll(){
        try{
            return ResponseEntity.ok(providerService.findAll());
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProviderDto> findById(@PathVariable int id){
        try{
            ProviderDto providerDto = providerService.findById(id);
            if(providerDto != null){
                return ResponseEntity.ok(providerDto);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> createProvider(@Validated @RequestBody ProviderCreateDto providerCreateDto){
        try{
            return ResponseEntity.ok(providerService.create(providerCreateDto));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try{
            ProviderDto providerDto = providerService.findById(id);
            if(providerDto != null){
                providerService.deleteById(id);
                return ResponseEntity.ok(id);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateProvider(@Validated @RequestBody ProviderUpdateDto providerUpdateDto){
        try{
            ProviderDto existProviderDto = providerService.findById(providerUpdateDto.getId());
            if(existProviderDto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(providerService.save(providerUpdateDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
