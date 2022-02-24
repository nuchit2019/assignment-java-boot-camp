package com.janawatECommerceSystem.janawatECommerceSystem.repository;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {
}
