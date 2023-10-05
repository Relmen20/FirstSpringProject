package com.study.oksk.dto;

import javax.validation.constraints.NotNull;

public class OperatorCreateDto {

    @NotNull
    private String operatorName;

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
