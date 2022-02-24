package com.janawatECommerceSystem.janawatECommerceSystem.models;

import javax.persistence.*;

@Entity
public class Receiver {
    @Id
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Receiver() {
    }

    public Receiver(String username, Address address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
