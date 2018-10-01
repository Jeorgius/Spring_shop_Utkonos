package com.jeorgius.shop.services.UpdateCommand;

import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.clothes.SummerClothes;
import com.jeorgius.shop.entities.clothes.WinterClothes;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
import com.jeorgius.shop.repos.Clothes.SummerRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSummer implements UpdateCommand{

    private SummerRepo summerRepo;
    private ClothesRepo clothesRepo;
    private UpdateOrder updateOrder;

    @Autowired
    public UpdateSummer(SummerRepo summerRepo, ClothesRepo clothesRepo, UpdateOrder updateOrder) {
        this.summerRepo = summerRepo;
        this.clothesRepo = clothesRepo;
        this.updateOrder = updateOrder;
    }

    @Override
    public void update(String subcategory, Integer itemId, Integer pQuantity) {
        SummerClothes item = summerRepo.findOneById(itemId);

        ItemCreds purchasedCreds = new ItemCreds().setTitle(item.getTitle())
                .setCategory(item.getCategory())
                .setSubcategory(item.getSubcategory())
                .setQuantity(pQuantity)
                .setPrice(item.getPrice());

        if(item.getQuantity()-purchasedCreds.getQuantity()>0){
            Integer q = item.getQuantity()-purchasedCreds.getQuantity();
            item.getSummerIC().setQuantity(q);
            item.setQuantity(q);
            item.getClothesIC().setQuantity(q);
        } else{
            purchasedCreds.setQuantity(item.getQuantity());
            item.getSummerIC().setQuantity(0);
            item.setQuantity(0);
        }
        clothesRepo.save(item);
        summerRepo.save(item);
        updateOrder.updateOrder(purchasedCreds);
    }

}