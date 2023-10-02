package com.study.oksk.dto;

import com.study.oksk.transfer.Update;
import com.study.oksk.transfer.New;

import javax.validation.constraints.*;

public class AddressDto{
    @Null(groups = {New.class})
    @NotNull(groups = {Update.class})
    private int id;

    @NotNull(groups = {New.class, Update.class})
    @Size(min = 1024, max = 65535)
    private int port;

    @NotNull(groups = {New.class, Update.class})
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
