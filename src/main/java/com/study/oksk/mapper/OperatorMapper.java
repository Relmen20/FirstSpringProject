package com.study.oksk.mapper;

import com.study.oksk.dto.OperatorCreateDto;
import com.study.oksk.dto.OperatorDto;
import com.study.oksk.dto.OperatorUpdateDto;
import com.study.oksk.entity.OperatorEntity;
import org.springframework.stereotype.Component;

@Component
public class OperatorMapper {
    public OperatorDto operatorEntityToDto(OperatorEntity operatorEntity){
        if(operatorEntity != null){
            OperatorDto operatorDto = new OperatorDto();
            operatorDto.setId(operatorEntity.getId());
            operatorDto.setOperatorName(operatorEntity.getOperatorName());
            return operatorDto;
        }else{
            return null;
        }
    }

    public OperatorEntity operatorCreateDtoToEntity(OperatorCreateDto operatorCreateDto){
        if(operatorCreateDto != null){
            OperatorEntity operatorEntity = new OperatorEntity();
            operatorEntity.setOperatorName(operatorCreateDto.getOperatorName());
            return operatorEntity;
        }else{
            return null;
        }
    }

    public OperatorEntity operatorUpdateDtoToEntity(OperatorUpdateDto operatorUpdateDto){
        if(operatorUpdateDto != null){
            OperatorEntity operatorEntity = new OperatorEntity();
            operatorEntity.setId(operatorUpdateDto.getId());
            operatorEntity.setOperatorName(operatorUpdateDto.getOperatorName());
            return operatorEntity;
        }else{
            return null;
        }
    }

    public OperatorEntity operatorDtoToEntity(OperatorDto operatorDto){
        if(operatorDto != null){
            OperatorEntity operatorEntity = new OperatorEntity();
            operatorEntity.setId(operatorDto.getId());
            operatorEntity.setOperatorName(operatorDto.getOperatorName());
            return operatorEntity;
        }else{
            return null;
        }
    }
}
