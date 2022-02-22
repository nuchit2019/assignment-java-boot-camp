package com.janawatECommerceSystem.janawatECommerceSystem.models;

import javax.persistence.Id;

public class Category {
    @Id
    int id;
    String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
