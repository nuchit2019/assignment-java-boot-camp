package com.janawat.ecommerce.customer;

import com.janawat.ecommerce.model.Address;
import com.janawat.ecommerce.model.Receiver;
import com.janawat.ecommerce.order.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private ReceiveRepository receiveRepository;
    @Autowired
    private AddressRepository addressRepository;

    public ReceiveRepository getReceiveRepository() {
        return receiveRepository;
    }

    public void setReceiveRepository(ReceiveRepository receiveRepository) {
        this.receiveRepository = receiveRepository;
    }

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

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
        //Sample data
        return true;
    }

}
