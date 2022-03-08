package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository
        extends JpaRepository<ProductReview, Integer> {
}
