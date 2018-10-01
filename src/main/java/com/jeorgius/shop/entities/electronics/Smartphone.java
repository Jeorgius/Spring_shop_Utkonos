package com.jeorgius.shop.entities.electronics;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;

import javax.persistence.*;

@Entity
@Table(name="smartphones", schema = "goods")
public class Smartphone extends Electronics {

    @Embedded
    private ItemCreds smartphoneIC;

    public Smartphone(){}
    public Smartphone(ItemCreds itemCreds){
        super(itemCreds);
        this.smartphoneIC = itemCreds;
    }

    public ItemCreds getSmartphoneIC() {
        return smartphoneIC;
    }

    public void setSmartphoneIC(ItemCreds smartphoneIC) {
        this.smartphoneIC = smartphoneIC;
    }
}
