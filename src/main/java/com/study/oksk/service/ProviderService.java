package com.study.oksk.service;

import com.study.oksk.dto.ProviderCreateDto;
import com.study.oksk.dto.ProviderDto;
import com.study.oksk.dto.ProviderUpdateDto;
import com.study.oksk.entity.ProviderEntity;
import com.study.oksk.mapper.ProviderMapper;
import com.study.oksk.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;
    private final AddressService addressService;

    @Autowired
    public ProviderService(ProviderRepository providerRepository, ProviderMapper providerMapper, AddressService addressService) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
        this.addressService = addressService;
    }

    public List<ProviderDto> findAll(){
        return providerRepository.findAll().stream()
                .map(providerMapper::providerEntityToDto)
                .collect(Collectors.toList());
    }

    public ProviderDto findById(int id){
        return providerMapper.providerEntityToDto(providerRepository.findById(id).orElse(null));
    }

    public int save(ProviderUpdateDto providerUpdateDto){
        ProviderDto providerDto = new ProviderDto();
        providerDto.setId(providerUpdateDto.getAddressId());
        providerDto.setAddressDto(addressService.findById(providerUpdateDto.getAddressId()));
        providerDto.setProviderName(providerUpdateDto.getProviderName());
        providerDto.setEmail(providerDto.getEmail());

        return providerRepository.save(providerMapper.providerUpdateDtoToEntity(providerDto)).getId();
    }

    public int create(ProviderCreateDto providerCreateDto) {
        ProviderDto providerDto = new ProviderDto();
        providerDto.setAddressDto(addressService.findById(providerCreateDto.getAddressId()));
        providerDto.setProviderName(providerCreateDto.getProviderName());
        providerDto.setEmail(providerCreateDto.getEmail());

        return providerRepository.save(providerMapper.providerCreateDtoToEntity(providerDto)).getId();
    }

    public void deleteById(int id){
        providerRepository.deleteById(id);
    }


}
