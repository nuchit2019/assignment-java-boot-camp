package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Address;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Receiver;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.AddressRepository;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.ReceiveRepository;
import com.janawatECommerceSystem.janawatECommerceSystem.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private ReceiveRepository receiveRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Address getDefaulAddress(String username) {
        return receiveRepository
                .findById(username)
                .map(Receiver::getAddress)
                .orElse(null);

    }

    public void setDefaultAddress(String username, Address address) {
        receiveRepository.save(new Receiver(username, address));
    }

    public Address getAddress(int id) {
        return addressRepository
                .findById(id)
                .orElse(null);

    }


    public boolean isMyAddress(String username, Integer addressId) {
        return true;
    }

}
