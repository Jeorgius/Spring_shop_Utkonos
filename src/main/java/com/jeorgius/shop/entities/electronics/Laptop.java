package com.jeorgius.shop.entities.electronics;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;

import javax.persistence.*;

@Entity
@Table(name="laptops", schema = "goods")
public class Laptop extends Electronics {

    @Embedded
    private ItemCreds laptopIC;

    public Laptop(){}
    public Laptop(ItemCreds itemCreds){
        super(itemCreds);
        this.laptopIC = itemCreds;
    }

    public ItemCreds getLaptopIC() {
        return laptopIC;
    }

    public void setLaptopIC(ItemCreds laptopIC) {
        this.laptopIC = laptopIC;
    }
}
