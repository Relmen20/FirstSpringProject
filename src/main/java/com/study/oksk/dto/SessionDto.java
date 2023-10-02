package com.study.oksk.dto;

import com.study.oksk.entity.OperatorEntity;
import com.study.oksk.entity.ProviderEntity;

public class SessionDto {
    private int id;
    private OperatorEntity operatorEntity;
    private String priorityType;
    private ProviderEntity providerEntity;
    private String sessionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperatorEntity getOperatorEntity() {
        return operatorEntity;
    }

    public void setOperatorEntity(OperatorEntity operatorEntity) {
        this.operatorEntity = operatorEntity;
    }

    public String getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(String priorityType) {
        this.priorityType = priorityType;
    }

    public ProviderEntity getProviderEntity() {
        return providerEntity;
    }

    public void setProviderEntity(ProviderEntity providerEntity) {
        this.providerEntity = providerEntity;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
}
