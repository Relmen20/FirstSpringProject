package com.study.oksk.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ProviderCreateDto {

    @NotNull
    private int addressId;

    @NotNull
    private String providerName;

    @NotNull
    private String email;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
