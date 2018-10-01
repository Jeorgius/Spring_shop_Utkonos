package com.jeorgius.shop.services.UpdateCommand;

import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.electronics.Laptop;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.entities.orders.UserAddress;
import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
import com.jeorgius.shop.repos.Electronics.LaptopRepo;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLaptop implements UpdateCommand{


    private ElectronicsRepo electronicsRepo;
    private LaptopRepo laptopRepo;
    private UpdateOrder updateOrder;

    @Autowired
    public UpdateLaptop(ElectronicsRepo electronicsRepo, LaptopRepo laptopRepo, UpdateOrder updateOrder) {
        this.electronicsRepo = electronicsRepo;
        this.laptopRepo = laptopRepo;
        this.updateOrder=updateOrder;
    }

    @Override
    public void update(String subcategory, Integer itemId, Integer pQuantity) {
        Laptop item = laptopRepo.findOneById(itemId);
        ItemCreds purchasedCreds = new ItemCreds().setTitle(item.getTitle())
                .setCategory(item.getCategory())
                .setSubcategory(item.getSubcategory())
                .setQuantity(pQuantity)
                .setPrice(item.getPrice());
        if(item.getQuantity()-purchasedCreds.getQuantity()>0){
            Integer q = item.getQuantity()-purchasedCreds.getQuantity();
            item.getLaptopIC().setQuantity(q);
            item.setQuantity(q);
            item.getElectronicsIC().setQuantity(q);
        } else{
            purchasedCreds.setQuantity(item.getQuantity());
            item.getLaptopIC().setQuantity(0);
            item.getElectronicsIC().setQuantity(0);
            item.setQuantity(0);
        }
        updateOrder.updateOrder(purchasedCreds);
        laptopRepo.save(item);
        electronicsRepo.save(item);
    }


}