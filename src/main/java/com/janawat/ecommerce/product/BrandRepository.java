package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository
        extends JpaRepository<Brand, Integer> {
}
