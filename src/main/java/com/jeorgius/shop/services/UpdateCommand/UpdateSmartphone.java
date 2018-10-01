package com.jeorgius.shop.services.UpdateCommand;

import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.electronics.Smartphone;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
import com.jeorgius.shop.repos.Electronics.SmartphoneRepo;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSmartphone implements UpdateCommand{

    private SmartphoneRepo smartphoneRepo;
    private ElectronicsRepo electronicsRepo;
    private UpdateOrder updateOrder;

    @Autowired
    public UpdateSmartphone(SmartphoneRepo smartphoneRepo, ElectronicsRepo electronicsRepo, UpdateOrder updateOrder) {
        this.smartphoneRepo = smartphoneRepo;
        this.electronicsRepo = electronicsRepo;
        this.updateOrder = updateOrder;
    }

    @Override
    public void update(String subcategory, Integer itemId, Integer pQuantity) {
        Smartphone item = smartphoneRepo.findOneById(itemId);

        ItemCreds purchasedCreds = new ItemCreds().setTitle(item.getTitle())
                .setCategory(item.getCategory())
                .setSubcategory(item.getSubcategory())
                .setQuantity(pQuantity)
                .setPrice(item.getPrice());

        if(item.getQuantity()-purchasedCreds.getQuantity()>0){
            Integer q = item.getQuantity()-purchasedCreds.getQuantity();
            item.getSmartphoneIC().setQuantity(q);
            item.getElectronicsIC().setQuantity(q);
            item.setQuantity(q);
        } else{
            purchasedCreds.setQuantity(item.getQuantity());
            item.getElectronicsIC().setQuantity(0);
            item.getSmartphoneIC().setQuantity(0);
            item.setQuantity(0);
        }
        smartphoneRepo.save(item);
        electronicsRepo.save(item);
        updateOrder.updateOrder(purchasedCreds);
    }
}
