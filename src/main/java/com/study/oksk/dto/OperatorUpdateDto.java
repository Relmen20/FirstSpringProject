package com.study.oksk.dto;

import javax.validation.constraints.NotNull;

public class OperatorUpdateDto {

    @NotNull
    private int id;

    @NotNull
    private String operatorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
