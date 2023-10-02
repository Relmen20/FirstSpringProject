package com.study.oksk.controller;

import com.study.oksk.dto.OperatorDto;
import com.study.oksk.service.OperatorService;
import com.study.oksk.transfer.New;
import com.study.oksk.transfer.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {

    private final OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping
    public ResponseEntity<List<OperatorDto>> findAll(){
        try{
            return ResponseEntity.ok(operatorService.findAll());
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OperatorDto> findById(@PathVariable int id){
        try{
            OperatorDto operatorDto = operatorService.findById(id);
            if(operatorDto != null){
                return ResponseEntity.ok(operatorDto);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> save(@Validated(value = {New.class}) @RequestBody OperatorDto operatorDto){
        try{
            return ResponseEntity.ok(operatorService.save(operatorDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try{
            OperatorDto operatorDto = operatorService.findById(id);
            if(operatorDto != null){
                operatorService.deleteById(id);
                return ResponseEntity.ok(operatorDto.getId());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Integer> update(@Validated(value = {Update.class}) @RequestBody OperatorDto updateOperatorDto){
        try{
            OperatorDto existOperatorDto = operatorService.findById(updateOperatorDto.getId());
            if(existOperatorDto != null){
                existOperatorDto.setOperatorName(updateOperatorDto.getOperatorName());
                return ResponseEntity.ok(operatorService.save(existOperatorDto));
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
