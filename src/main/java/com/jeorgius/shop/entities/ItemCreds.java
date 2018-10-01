package com.jeorgius.shop.entities;

import javax.persistence.Embeddable;

@Embeddable
public class ItemCreds {
    private String title;
    private String category;
    private String subcategory;
    private Integer price;
    private Integer quantity;


    public String getTitle() {
        return title;
    }

    public ItemCreds setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ItemCreds setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public ItemCreds setSubcategory(String subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public ItemCreds setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ItemCreds setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
