package com.jeorgius.shop.entities.clothes;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "winterclothes", schema="goods")
public class WinterClothes extends Clothes {

    @Embedded
    private ItemCreds winterIC;

    public WinterClothes(){}
    public WinterClothes(ItemCreds itemCreds){
        super(itemCreds);
        this.winterIC = itemCreds;
    }

    public ItemCreds getWinterIC() {
        return winterIC;
    }

    public void setWinterIC(ItemCreds winterIC) {
        this.winterIC = winterIC;
    }
}
