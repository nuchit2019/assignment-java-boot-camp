package com.janawatECommerceSystem.janawatECommerceSystem.repository;

import com.janawatECommerceSystem.janawatECommerceSystem.models.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiveRepository
        extends JpaRepository<Receiver, String> {
}
