package com.janawat.ecommerce.services;

import com.janawat.ecommerce.customer.AddressService;
import com.janawat.ecommerce.model.Address;
import com.janawat.ecommerce.model.Receiver;
import com.janawat.ecommerce.customer.AddressRepository;
import com.janawat.ecommerce.order.ReceiveRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private ReceiveRepository receiveRepository;

    @Mock
    private AddressRepository addressRepository;



    @Test
    @DisplayName("ค้นหา user=user1 ต้องได้ FullAddress ของ user1")
    public void getDefaulAddress() {

        String username="user1";
        Address address = new Address(1, "Nuchit Atjanawat", "No.247 Soi village is prosperous.", "085 911 7659", "Wang Thonglang", "Bangkok", "10310");


        String expected =
                address.getFullName()  + "Name: " +
                address.getAddress() + " Address: " +
                address.getPhone() + " phone: " +
                address.getDistrict() + " district: " +
                address.getProvince() + " province: " +
                address.getPostCode();


        Receiver receiver = new Receiver();
        receiver.setUsername(username);
        receiver.setAddress(address);


        when(receiveRepository.findById(username)).thenReturn(Optional.of(receiver));

        AddressService addressService  = new AddressService();
        addressService.setReceiveRepository(receiveRepository);

        String result = addressService.getDefaulAddress(username).getFullAddress();
        assertEquals(expected, result);
    }





    @Test
    @DisplayName("ค้นหา user=user1 ต้องได้ Address ของ user")
    void getAddress() {
        String username="user1";
        Address address = new Address(1, "Nuchit Atjanawat", "No.247 Soi village is prosperous.", "085 911 7659", "Wang Thonglang", "Bangkok", "10310");


        String expected = address.getAddress() ;

        Receiver receiver = new Receiver();
        receiver.setUsername(username);
        receiver.setAddress(address);


        when(receiveRepository.findById(username)).thenReturn(Optional.of(receiver));

        AddressService addressService  = new AddressService();
        addressService.setReceiveRepository(receiveRepository);

        String result = addressService.getDefaulAddress(username).getAddress() ;
        assertEquals(expected, result);
    }

}