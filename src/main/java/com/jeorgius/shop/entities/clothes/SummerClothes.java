package com.jeorgius.shop.entities.clothes;


import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "summerclothes", schema = "goods")
public class SummerClothes extends Clothes {

    @Embedded
    private ItemCreds summerIC;

    public SummerClothes(){}
    public SummerClothes(ItemCreds itemCreds) {
        super(itemCreds);
        this.summerIC = itemCreds;
    }

    public ItemCreds getSummerIC() {
        return summerIC;
    }

    public void setSummerIC(ItemCreds summerIC) {
        this.summerIC = summerIC;
    }
}
