package com.study.oksk.service;

import com.study.oksk.dto.SessionCreateDto;
import com.study.oksk.dto.SessionDto;
import com.study.oksk.dto.SessionUpdateDto;
import com.study.oksk.entity.SessionEntity;
import com.study.oksk.mapper.SessionMapper;
import com.study.oksk.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final ProviderService providerService;
    private final OperatorService operatorService;
    private final SessionMapper sessionMapper;

    @Autowired
    public SessionService(SessionRepository sessionRepository, ProviderService providerService, OperatorService operatorService, SessionMapper sessionMapper) {
        this.sessionRepository = sessionRepository;
        this.providerService = providerService;
        this.operatorService = operatorService;
        this.sessionMapper = sessionMapper;
    }

    public SessionDto findById(int id){
        return sessionMapper.sessionEntityToDto(sessionRepository.findById(id).orElse(null));
    }

    public List<SessionDto> findAll(){
        return sessionRepository.findAll().stream()
                .map(sessionMapper::sessionEntityToDto)
                .collect(Collectors.toList());
    }

    public int create(SessionCreateDto sessionCreateDto){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setSessionName(sessionCreateDto.getSessionName());
        sessionDto.setPriorityType(sessionCreateDto.getPriorityType());
        sessionDto.setOperatorDto(operatorService.findById(sessionCreateDto.getOperatorId()));
        sessionDto.setProviderDto(providerService.findById(sessionCreateDto.getProviderId()));

        SessionEntity sessionEntity = sessionMapper.sessionCreateDtoToEntity(sessionDto);

        System.out.println(sessionEntity.toString());

        return sessionRepository.save(sessionEntity).getId();
    }

    public int save(SessionUpdateDto sessionUpdateDto){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(sessionUpdateDto.getId());
        sessionDto.setSessionName(sessionUpdateDto.getSessionName());
        sessionDto.setPriorityType(sessionUpdateDto.getPriorityType());
        sessionDto.setOperatorDto(operatorService.findById(sessionUpdateDto.getOperatorId()));
        sessionDto.setProviderDto(providerService.findById(sessionUpdateDto.getProviderId()));

        return sessionRepository.save(sessionMapper.sessionUpdateDtoToEntity(sessionDto)).getId();
    }

    public void deleteById(int id){
        sessionRepository.deleteById(id);
    }
}