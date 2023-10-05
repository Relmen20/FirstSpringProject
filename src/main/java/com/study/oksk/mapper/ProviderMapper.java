package com.study.oksk.mapper;

import com.study.oksk.dto.ProviderDto;
import com.study.oksk.entity.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public ProviderMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }

    public ProviderDto providerEntityToDto(ProviderEntity providerEntity){
        if(providerEntity != null){
            ProviderDto providerDto = new ProviderDto();
            providerDto.setId(providerEntity.getId());
            providerDto.setProviderName(providerEntity.getProviderName());
            providerDto.setAddressDto(addressMapper.addressEntityToDto(providerEntity.getAddressEntity()));
            providerDto.setEmail(providerEntity.getEmail());
            return providerDto;
        }else{
            return null;
        }
    }

    public ProviderEntity providerCreateDtoToEntity(ProviderDto providerDto){
        if(providerDto != null){
            ProviderEntity providerEntity = new ProviderEntity();
            providerEntity.setProviderName(providerDto.getProviderName());
            providerEntity.setAddressEntity(addressMapper.addressDtoToEntity(providerDto.getAddressDto()));
            providerEntity.setEmail(providerDto.getEmail());
            return providerEntity;
        }else{
            return null;
        }
    }

    public ProviderEntity providerUpdateDtoToEntity(ProviderDto providerDto) {
        if(providerDto != null){
            ProviderEntity providerEntity = new ProviderEntity();
            providerEntity.setId(providerDto.getId());
            providerEntity.setProviderName(providerDto.getProviderName());
            providerEntity.setEmail(providerDto.getEmail());
            return providerEntity;
        }else{
            return null;
        }
    }

    public ProviderEntity providerDtoToEntity(ProviderDto providerDto) {
        if(providerDto != null){
            ProviderEntity providerEntity = new ProviderEntity();
            providerEntity.setId(providerDto.getId());
            providerEntity.setAddressEntity(addressMapper.addressDtoToEntity(providerDto.getAddressDto()));
            providerEntity.setProviderName(providerDto.getProviderName());
            providerEntity.setEmail(providerDto.getEmail());
            return providerEntity;
        }else{
            return null;
        }
    }
}
