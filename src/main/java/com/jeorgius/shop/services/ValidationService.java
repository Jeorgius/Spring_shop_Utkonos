package com.jeorgius.shop.services;

import com.jeorgius.shop.entities.orders.ItemInPurchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {
    public String getCategory(String subcategory){
        if (subcategory.equals("smartphones") ||
                subcategory.equals("laptops")){
            return "electronics";
        }
        if (subcategory.equals("winter") ||
                subcategory.equals("summer")){
            return "clothes";
        }
        return "";
    }

    public Integer calculatePrice(List<ItemInPurchase> toOrder){
        Integer totalPrice = 0;
        for (ItemInPurchase item: toOrder) {
            totalPrice += item.getPrice()*item.getQuantity();
        }
        return totalPrice;
    }
}
