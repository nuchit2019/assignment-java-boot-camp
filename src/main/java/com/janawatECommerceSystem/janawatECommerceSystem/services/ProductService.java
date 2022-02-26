package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.ProductNotFoundException;
import com.janawatECommerceSystem.janawatECommerceSystem.models.CartItem;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Product;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.models.ProductReview;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    public Integer adjustProduct(CartItem item) {

        Product product = productRepository.findById(item.getProductId()).get();
        Integer inStok = product.getInStock() - item.getQuantity();
        product.setInStock(inStok);

        productRepository.save(product);

        return inStok;
    }

    public boolean isInstokCanOrder(CartItem item) {

        Product product = productRepository.findById(item.getProductId()).get();
        if (product.getInStock() >= item.getQuantity())
            return true;

        return false;
    }


    public List<ProductResponse> getProductsByName(String productName, int pageNumber) {

        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> productList = productRepository.findByProductNameContains(productName, pageable);

        List<ProductResponse> productsResponse =
                productList.stream()
                        .map(e -> setProductResponse(e))
                        .collect(Collectors.toList());

        return productsResponse;
    }


    public List<ProductResponse> getProductsAll(int pageNumber) {
        //int pageNumber = 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> products = productRepository.findAll(pageable);

        List<ProductResponse> productsResponse =
                products.stream()
                        .map(e -> setProductResponse(e))
                        .collect(Collectors.toList());

        return productsResponse;
    }

    public Optional<Product> getProductsByName(String name) {

        System.out.println("ProductService...getProductsAll_1");
        return productRepository.findByProductName(name);
    }



    private ProductResponse setProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setInStock(product.getInStock());
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

    public Product getProduct(int productId) {
        return productRepository.findById(productId).orElse(null);
    }



    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
