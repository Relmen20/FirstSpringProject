package com.study.oksk.controller;

import com.study.oksk.dto.SessionCreateDto;
import com.study.oksk.dto.SessionDto;
import com.study.oksk.dto.SessionUpdateDto;
import com.study.oksk.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/session")
@Validated
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public ResponseEntity<List<SessionDto>> findAllSession(){
        try {
            return ResponseEntity.ok(sessionService.findAll());
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SessionDto> findById(@PathVariable int id){
        try{
            SessionDto sessionDto = sessionService.findById(id);
            if(sessionDto != null){
                return ResponseEntity.ok(sessionDto);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> createSession(@Validated @RequestBody SessionCreateDto sessionCreateDto){
        try{
            return ResponseEntity.ok(sessionService.create(sessionCreateDto));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateSession(@Validated @RequestBody SessionUpdateDto sessionUpdateDto){
        try{
            SessionDto sessionDto = sessionService.findById(sessionUpdateDto.getId());
            if(sessionDto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(sessionService.save(sessionUpdateDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try{
            SessionDto sessionDto = sessionService.findById(id);
            if(sessionDto != null){
                sessionService.deleteById(id);
                return ResponseEntity.ok(id);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
