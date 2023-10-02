package com.study.oksk.entity;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL) //#TODO состояния сущностей в hybernate и CascadeType
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity addressEntity;
    @Column(name = "provider_name")
    private String provider_name;
    @Column(name = "email")
    private String email;

    public ProviderEntity(){}

    public ProviderEntity(int id, AddressEntity addressEntity, String provider_name, String email) {
        this.id = id;
        this.addressEntity = addressEntity;
        this.provider_name = provider_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
