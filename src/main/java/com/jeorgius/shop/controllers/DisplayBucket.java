package com.jeorgius.shop.controllers;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.clothes.SummerClothes;
import com.jeorgius.shop.entities.clothes.WinterClothes;
import com.jeorgius.shop.entities.electronics.Laptop;
import com.jeorgius.shop.entities.electronics.Smartphone;
import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.entities.orders.Purchase;
import com.jeorgius.shop.entities.orders.UserAddress;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
import com.jeorgius.shop.repos.Clothes.SummerRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
import com.jeorgius.shop.repos.Electronics.LaptopRepo;
import com.jeorgius.shop.repos.Electronics.SmartphoneRepo;
import com.jeorgius.shop.repos.ItemRepo;
import com.jeorgius.shop.repos.Purchases.ItemInPurchaseRepo;
import com.jeorgius.shop.repos.Purchases.PurchaseRepo;
import com.jeorgius.shop.repos.Purchases.UserAddressRepo;
import com.jeorgius.shop.services.UpdateItem;
import com.jeorgius.shop.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@SessionScope
public class DisplayBucket {

    private ItemCreds itemCreds;

    private ItemInPurchaseRepo itemInPurchaseRepo;
    private PurchaseRepo purchaseRepo;
    private UserAddressRepo userAddressRepo;
    private UpdateItem updateItem;
    private ValidationService validationService;

    @Autowired
    public DisplayBucket(ItemInPurchaseRepo itemInPurchaseRepo, PurchaseRepo purchaseRepo, UpdateItem updateItem, ValidationService validationService, UserAddressRepo userAddressRepo) {
        this.itemInPurchaseRepo = itemInPurchaseRepo;
        this.purchaseRepo = purchaseRepo;
        this.updateItem = updateItem;
        this.validationService = validationService;
        this.userAddressRepo = userAddressRepo;
    }

    @GetMapping("/orders")
    public String orders(Model model){
        List<ItemInPurchase> toOrder = purchaseRepo.findFirstByOrderByIdDesc().getItemInPurchases();
        Integer total = validationService.calculatePrice(toOrder);

        model.addAttribute("items", toOrder);
        model.addAttribute("total", total);
        return "orders";
    }
    @PostMapping("/orders/createorder")
    public String createOrder (Model model){
        Purchase purchase = new Purchase();
        UserAddress userAddress = new UserAddress();
        userAddressRepo.save(userAddress);
        purchase.setUserAddress(userAddress);
        purchaseRepo.save(purchase);
        userAddress.setPurchase(purchase);
        userAddressRepo.save(userAddress);
        return "shop";
    }

    @PostMapping("/orders/addtobucket")
    public String addToBucket ( @RequestParam String pQuantity,
                                @RequestParam String itemId,
                                @RequestParam String sub,
                                Model model){
        if(Integer.parseInt(pQuantity)>0) updateItem.update(sub, Integer.parseInt(itemId), Integer.parseInt(pQuantity));

        return "orders";
    }

    @PostMapping("/orders/getcreds")
    public String setCreds (){
        return "addresspage";
    }

    @PostMapping("/order/setcreds")
    public String confirmAddress (@RequestParam String country,
                                  @RequestParam String city,
                                  @RequestParam String index,
                                  @RequestParam String payMethod,
                                  Model model){
        Purchase purchase = purchaseRepo.findFirstByOrderByIdDesc();
        purchase.getUserAddress().setCountry(country);
        purchase.getUserAddress().setCity(city);
        purchase.getUserAddress().setIndex(Integer.parseInt(index));
        purchase.setPayMethod(payMethod);
        purchaseRepo.save(purchase);
        model.addAttribute("purchase", purchase);
        model.addAttribute("address", purchase.getUserAddress());
        return "confirmation";
    }
}
