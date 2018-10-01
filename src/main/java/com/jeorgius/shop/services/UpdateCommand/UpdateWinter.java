package com.jeorgius.shop.services.UpdateCommand;

import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.clothes.WinterClothes;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateWinter implements UpdateCommand{

    private WinterRepo winterRepo;
    private ClothesRepo clothesRepo;
    private UpdateOrder updateOrder;

    @Autowired
    public UpdateWinter(WinterRepo winterRepo, ClothesRepo clothesRepo, UpdateOrder updateOrder) {
        this.winterRepo = winterRepo;
        this.clothesRepo = clothesRepo;
        this.updateOrder = updateOrder;
    }

    @Override
    public void update(String subcategory, Integer itemId, Integer pQuantity) {
        WinterClothes item = winterRepo.findOneById(itemId);

        ItemCreds purchasedCreds = new ItemCreds().setTitle(item.getTitle())
                .setCategory(item.getCategory())
                .setSubcategory(item.getSubcategory())
                .setQuantity(pQuantity)
                .setPrice(item.getPrice());

        if(item.getQuantity()-purchasedCreds.getQuantity()>0){
            Integer q = item.getQuantity()-purchasedCreds.getQuantity();
            item.getWinterIC().setQuantity(q);
            item.setQuantity(q);
            item.getClothesIC().setQuantity(q);
        } else{
            purchasedCreds.setQuantity(item.getQuantity());
            item.getWinterIC().setQuantity(0);
            item.getClothesIC().setQuantity(0);
            item.setQuantity(0);
        }

        winterRepo.save(item);
        clothesRepo.save(item);
        updateOrder.updateOrder(purchasedCreds);
    }
}
