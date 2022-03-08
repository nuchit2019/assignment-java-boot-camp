package com.janawat.ecommerce.customer;

import com.janawat.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository
        extends JpaRepository<Address, Integer> {
}
