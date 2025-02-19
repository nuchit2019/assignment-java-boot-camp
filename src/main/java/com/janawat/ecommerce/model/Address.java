package com.janawat.ecommerce.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    private int id;
    private String fullName;
    private String address;
    private String phone;
    private String district;
    private String province;
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    public Address() {
    }


    public Address(int id, String fullName, String address, String phone, String district, String province, String postCode) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.district = district;
        this.province = province;
        this.postCode = postCode;
    }

    public Address(String fullName, String address, String phone, String district, String province, String postCode) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.district = district;
        this.province = province;
        this.postCode = postCode;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFullAddress() {

        String fullAddress =
                this.fullName + "Name: " +
                        this.address + " Address: " +
                        this.phone + " phone: " +
                        this.district + " district: " +
                        this.province + " province: " +
                        this.postCode;

        return fullAddress;
    }
}
