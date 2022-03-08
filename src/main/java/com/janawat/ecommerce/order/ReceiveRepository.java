package com.janawat.ecommerce.order;

import com.janawat.ecommerce.model.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiveRepository
        extends JpaRepository<Receiver, String> {
}
