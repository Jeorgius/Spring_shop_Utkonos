package com.jeorgius.shop.entities.clothes;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clothes", schema = "goods")
@Inheritance(strategy = InheritanceType.JOINED)
public class Clothes extends Item {

    @Embedded
    private ItemCreds clothesIC;

    public Clothes() {}
    public Clothes(ItemCreds itemCreds){
        super(itemCreds);
        this.clothesIC = itemCreds;
    }

    public ItemCreds getClothesIC() {
        return clothesIC;
    }

    public void setClothesIC(ItemCreds clothesIC) {
        this.clothesIC = clothesIC;
    }
}
