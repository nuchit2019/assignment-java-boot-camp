package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository
        extends JpaRepository<Shop, Integer> {
}
