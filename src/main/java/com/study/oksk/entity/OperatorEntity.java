package com.study.oksk.entity;

import javax.persistence.*;

@Entity
@Table(name = "operator")
public class OperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "operator_name")
    private String operator_name;

    public OperatorEntity(){}

    public OperatorEntity(int id, String operator_name) {
        this.id = id;
        this.operator_name = operator_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }
}
