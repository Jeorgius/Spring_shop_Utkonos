package com.jeorgius.shop.services.UpdateCommand;

import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.entities.orders.Purchase;
import com.jeorgius.shop.entities.orders.UserAddress;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import com.jeorgius.shop.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrder {

    private PurchaseRepo purchaseRepo;
    private ItemInPurchaseRepo itemInPurchaseRepo;
    private ValidationService validationService;

    @Autowired
    public UpdateOrder(PurchaseRepo purchaseRepo, ItemInPurchaseRepo itemInPurchaseRepo, ValidationService validationService) {
        this.purchaseRepo = purchaseRepo;
        this.itemInPurchaseRepo = itemInPurchaseRepo;
        this.validationService = validationService;
    }

    public void updateOrder(ItemCreds itemCreds){
        ItemInPurchase iiP = new ItemInPurchase(itemCreds);
        Purchase purchase = purchaseRepo.findFirstByOrderByIdDesc();
        iiP.setPurchase(purchase);
        itemInPurchaseRepo.save(iiP);
        purchase.setTotal(validationService.calculatePrice(itemInPurchaseRepo.findByPurchase(purchase)));
        purchaseRepo.save(purchase);
    }
}
