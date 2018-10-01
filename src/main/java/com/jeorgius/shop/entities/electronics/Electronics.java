package com.jeorgius.shop.entities.electronics;


import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;

import javax.persistence.*;

@Entity
@Table(name="electronics", schema = "goods")
@Inheritance(strategy = InheritanceType.JOINED)
public class Electronics extends Item {

    @Embedded
    private ItemCreds electronicsIC;

    public Electronics(){}
    public Electronics(ItemCreds itemCreds){
        super(itemCreds);
        this.electronicsIC = itemCreds;
    }

    public ItemCreds getElectronicsIC() {
        return electronicsIC;
    }

    public void setElectronicsIC(ItemCreds electronicsIC) {
        this.electronicsIC = electronicsIC;
    }
}
