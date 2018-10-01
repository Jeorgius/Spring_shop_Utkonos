package com.jeorgius.shop.entities.orders;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items_in_purchase", schema = "goods")
@SequenceGenerator(name="h", sequenceName = "goods.hibernate_sequence")
public class ItemInPurchase {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h")
    private Integer id;

    private String title;
    private String category;
    private String subcategory;
    private Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name="purchase_id")
    private Purchase purchase;

    public ItemInPurchase(){}
    public ItemInPurchase(ItemCreds itemInfo){

        this.title = itemInfo.getTitle();
        this.category = itemInfo.getCategory();
        this.subcategory=itemInfo.getSubcategory();
        this.quantity=itemInfo.getQuantity();
        this.price=itemInfo.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
