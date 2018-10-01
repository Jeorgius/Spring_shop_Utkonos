package com.jeorgius.shop.entities;


import com.jeorgius.shop.entities.clothes.Clothes;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="className")
@Table(name="items", schema = "goods")
@SequenceGenerator(name="h", sequenceName = "goods.hibernate_sequence")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "h")
    private Integer id;

//    @Embedded
//    private ItemCreds itemCreds;
    private String title;
    private String category;
    private String subcategory;
    private Integer price;
    private Integer quantity;

    public Item(){}
    public Item(ItemCreds itemCreds){
        this.title = itemCreds.getTitle();
        this.category = itemCreds.getCategory();
        this.subcategory = itemCreds.getSubcategory();
        this.price = itemCreds.getPrice();
        this.quantity = itemCreds.getQuantity();
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
