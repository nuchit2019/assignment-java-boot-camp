package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductModelRepository
        extends JpaRepository<ProductModel, Integer> {
}
