package com.janawat.ecommerce.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    private int id;
    private String customerName;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Customer() {
    }

    public Customer(int id, String customerName ) {
        this.id = id;
        this.customerName = customerName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
