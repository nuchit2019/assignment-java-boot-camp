package com.janawat.ecommerce.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    private int id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_percent")
    private Double discountPercent;

    @Column(name = "promotion_end_date")
    private String promotionEndDate;

    @Column(name = "is_delivery_discount")
    private int isDeliveryDiscount;

    @Column(name = "product_model_id")
    private int productModelId;

    @Column(name = "InStock")
    private int InStock;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "productImagesList", length = 1000)
    private String[] productImagesList;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "size")
    private String[] sizes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shop_id", insertable = false, updatable = false)

    private Shop shop;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_model_id", insertable = false, updatable = false)
    private ProductModel productModel;

    //@OneToMany(mappedBy = "product_id")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product_id", cascade = CascadeType.ALL)
    private List<ProductReview> productReviews;


    //private Collection<ProductReview> productReviews = new LinkedHashSet<ProductReview>();

    public Product() {
    }

    public Product(int id, String productName, String description, Double price, Double discountPercent, String promotionEndDate, int isDeliveryDiscount, int productModelId, int InStock, String productImage, String[] productImagesList, int brandId, int shopId, String status, Date createdDate, Date updatedDate, String[] sizes) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.discountPercent = discountPercent;
        this.promotionEndDate = promotionEndDate;
        this.isDeliveryDiscount = isDeliveryDiscount;
        this.productModelId = productModelId;
        this.InStock = InStock;
        this.productImage = productImage;
        this.productImagesList = productImagesList;
        this.brandId = brandId;
        this.shopId = shopId;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sizes = sizes;

    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String[] getProductImagesList() {
        return productImagesList;
    }

    public void setProductImagesList(String[] productImagesList) {
        this.productImagesList = productImagesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(String promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public int getIsDeliveryDiscount() {
        return isDeliveryDiscount;
    }

    public void setIsDeliveryDiscount(int isDeliveryDiscount) {
        this.isDeliveryDiscount = isDeliveryDiscount;
    }

    public int getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(int productModelId) {
        this.productModelId = productModelId;
    }


    public void setSecondaryImages(String[] productImagesList) {
        this.productImagesList = productImagesList;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}