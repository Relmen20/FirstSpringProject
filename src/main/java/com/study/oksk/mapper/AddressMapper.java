package com.study.oksk.mapper;

import com.study.oksk.dto.AddressDto;
import com.study.oksk.entity.AddressEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class AddressMapper{ //TODO переписать с проверкой параметров на null +++

    public AddressEntity addressDtoToEntity(AddressDto addressDto) {
        if (addressDto != null){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setId(addressDto.getId());
            addressEntity.setPort(addressDto.getPort());
            addressEntity.setAddress(addressDto.getAddress());
            return addressEntity;
        }else{
            return null;
        }
    }

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
}
