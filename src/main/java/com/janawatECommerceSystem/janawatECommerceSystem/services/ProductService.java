package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.ProductNotFoundException;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductReview;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        ProductResponse productresponse = setProductResponse(product.get());
        return productresponse;
    }

    public List<ProductResponse> getProducts(String search) {
        List<Product> products;
        if (search != null && !search.isEmpty()) {
            products = productRepository.findByProductName(search);
        } else {
            products = productRepository.findAll();
        }
        List<ProductResponse> productsResponse = products.stream().map(e -> setProductResponse(e)).collect(Collectors.toList());
        return productsResponse;
    }

    public List<ProductResponse> getProductsAll() {
        List<Product> products = productRepository.findAll();

        List<ProductResponse> productsResponse = products.stream().map(e -> setProductResponse(e)).collect(Collectors.toList());
        return productsResponse;
    }


    private ProductResponse setProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getProductName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscountPercent(product.getDiscountPercent());
        productResponse.setNetPrice(product.getPrice() - (product.getDiscountPercent() * product.getPrice()) / 100);
        productResponse.setPromotionEndDate(product.getPromotionEndDate());
        productResponse.setIsDeliveryDiscount(product.getIsDeliveryDiscount());
        productResponse.setProductModelName(product.getProductModel().getName());
        productResponse.setProductImage(product.getProductImage());
        productResponse.setProductImageList(product.getProductImagesList());
        productResponse.setBrandName(product.getBrand().getBrandName());
        productResponse.setShopName(product.getShop().getName());
        productResponse.setShopProvince(product.getShop().getProvince());
        productResponse.setStatus(product.getStatus());
        productResponse.setSizes(product.getSizes());
        productResponse.setReviewerCount(product.getProductReviews().size());
        productResponse.setScore(calculateReviewScore(product.getProductReviews()));

        return productResponse;
    }

    private int calculateReviewScore(List<ProductReview> productReviews) {
        if (productReviews.size() == 0) {
            return 0;
        }
        return productReviews.stream().mapToInt(e -> e.getScore()).sum() / productReviews.size();
    }


}
