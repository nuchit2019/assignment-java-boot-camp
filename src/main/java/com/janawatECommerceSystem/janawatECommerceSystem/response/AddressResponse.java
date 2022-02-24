package com.janawatECommerceSystem.janawatECommerceSystem.response;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressResponse {
    private Integer id;
    private String fullName;
    private String address;
    private String postcode;
    private String district;
    private String province;
    private String phone;

    public AddressResponse() {
    }

    public AddressResponse(Integer id, String fullName, String address, String postcode, String district, String province, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.postcode = postcode;
        this.district = district;
        this.province = province;
        this.phone = phone;
    }

    public static AddressResponse fromAddress(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getFullName(),
                address.getAddress(),
                address.getPostCode(),
                address.getDistrict(),
                address.getProvince(),
                address.getPhone()
        );
    }


    public AddressResponse fromAddress2(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getFullName(),
                address.getAddress(),
                address.getPostCode(),
                address.getDistrict(),
                address.getProvince(),
                address.getPhone()
        );
    }

    public Address toAddress() {
        Address address = new Address(
                getFullName(),
                getAddress(),
                getPostcode(),
                getDistrict(),
                getProvince(),
                getPhone()
        );

        address.setId(id);
        return address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
