package com.study.oksk.dto;

import com.study.oksk.transfer.New;
import com.study.oksk.transfer.Update;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class OperatorDto {

    @Null(groups = {New.class})
    @NotNull(groups = {Update.class})
    private int id;

    @NotNull(groups = {New.class, Update.class})
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
