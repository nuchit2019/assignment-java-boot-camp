package com.janawat.ecommerce.product;

import com.janawat.ecommerce.model.Product;
import com.janawat.ecommerce.model.ProductResponse;
import com.janawat.ecommerce.model.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductResponse productResponse;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Optional<Product> findById(int id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        return product;
    }


    public Integer adjustProduct(int productId, int quantity) {

        Product product = productRepository.findById(productId).get();
        Integer inStok = product.getInStock() - quantity;
        product.setInStock(inStok);

        productRepository.save(product);

        return inStok;
    }

    public boolean isInstokCanOrder(int productId, int quantity) {

        Product product = productRepository.findById(productId).get();
        if (product.getInStock() >= quantity)
            return true;

        return false;
    }


    public Page<Product> findByProductNameContains(String productName, int pageNumber) {

        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> productList
                = productRepository
                .findByProductNameContains(productName, pageable);

        return productList;
    }


    public Page<Product> getProductsAll(int pageNumber) {

        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> products = productRepository.findAll(pageable);


        return products;
    }

    public Optional<Product> findByProductNameContains(String name) {

        System.out.println("ProductService...getProductsAll_1");
        return productRepository.findByProductName(name);
    }


    public List<Product> findAll() {

        return productRepository.findAll();
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


}
