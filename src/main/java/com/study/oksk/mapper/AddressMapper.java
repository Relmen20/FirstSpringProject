package com.study.oksk.mapper;

import com.study.oksk.dto.AddressCreateDto;
import com.study.oksk.dto.AddressDto;
import com.study.oksk.dto.AddressUpdateDto;
import com.study.oksk.entity.AddressEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class AddressMapper{

    public AddressDto addressEntityToDto(AddressEntity addressEntity){
        if (addressEntity != null) {
            AddressDto addressDto = new AddressDto();
            addressDto.setId(addressEntity.getId());
            addressDto.setAddress(addressEntity.getAddress());
            addressDto.setPort(addressEntity.getPort());
            return addressDto;
        }else{
            return null;
        }
    }

    public AddressEntity addressDtoToEntity(AddressDto addressDto){
        if(addressDto != null){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setId(addressDto.getId());
            addressEntity.setPort(addressDto.getPort());
            addressEntity.setAddress(addressDto.getAddress());
            return addressEntity;
        }else{
            return null;
        }
    }

    public AddressEntity addressCreateDtoToEntity(AddressCreateDto addressCreateDto){
        if (addressCreateDto != null){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setPort(addressCreateDto.getPort());
            addressEntity.setAddress(addressCreateDto.getAddress());
            return addressEntity;
        }else{
            return null;
        }
    }

    public AddressEntity addressUpdateDtoToEntity(AddressUpdateDto addressUpdateDto) {
        if (addressUpdateDto != null){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setId(addressUpdateDto.getId());
            addressEntity.setPort(addressUpdateDto.getPort());
            addressEntity.setAddress(addressUpdateDto.getAddress());
            return addressEntity;
        }else{
            return null;
        }
    }
}
