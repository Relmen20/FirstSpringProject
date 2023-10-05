package com.study.oksk.mapper;

import com.study.oksk.dto.SessionDto;
import com.study.oksk.entity.SessionEntity;
import com.study.oksk.model.PriorityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {

    private final ProviderMapper providerMapper;
    private final OperatorMapper operatorMapper;

    @Autowired
    public SessionMapper(ProviderMapper providerMapper, OperatorMapper operatorMapper) {



        this.providerMapper = providerMapper;
        this.operatorMapper = operatorMapper;
    }

    public SessionDto sessionEntityToDto(SessionEntity sessionEntity){
        if(sessionEntity != null){
            SessionDto sessionDto = new SessionDto();
            sessionDto.setId(sessionEntity.getId());
            sessionDto.setSessionName(sessionEntity.getSessionName());
            sessionDto.setOperatorDto(operatorMapper.operatorEntityToDto(sessionEntity.getOperator()));
            sessionDto.setProviderDto(providerMapper.providerEntityToDto(sessionEntity.getProvider()));
            sessionDto.setPriorityType(sessionEntity.getPriorityType().name());
            return sessionDto;
        }else{
            return null;
        }
    }

    public SessionEntity sessionCreateDtoToEntity(SessionDto sessionDto){
        if(sessionDto != null){
            SessionEntity sessionEntity = new SessionEntity();
            sessionEntity.setSessionName(sessionDto.getSessionName());
            sessionEntity.setOperator(operatorMapper.operatorDtoToEntity(sessionDto.getOperatorDto()));
            sessionEntity.setProvider(providerMapper.providerDtoToEntity(sessionDto.getProviderDto()));
            sessionEntity.setPriorityType(PriorityType.valueOf(sessionDto.getPriorityType()));
            return sessionEntity;
        }else{
            return null;
        }
    }

    public SessionEntity sessionUpdateDtoToEntity(SessionDto sessionDto){
        if(sessionDto != null){
            SessionEntity sessionEntity = new SessionEntity();
            sessionEntity.setId(sessionDto.getId());
            sessionEntity.setSessionName(sessionDto.getSessionName());
            sessionEntity.setOperator(operatorMapper.operatorDtoToEntity(sessionDto.getOperatorDto()));
            sessionEntity.setProvider(providerMapper.providerDtoToEntity(sessionDto.getProviderDto()));
            sessionEntity.setPriorityType(PriorityType.valueOf(sessionDto.getPriorityType()));
            return sessionEntity;
        }else{
            return null;
        }
    }
}
