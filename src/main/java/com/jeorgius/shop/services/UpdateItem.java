package com.jeorgius.shop.services;

import com.jeorgius.shop.entities.clothes.SummerClothes;
import com.jeorgius.shop.entities.clothes.WinterClothes;
import com.jeorgius.shop.entities.electronics.Laptop;
import com.jeorgius.shop.entities.electronics.Smartphone;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
import com.jeorgius.shop.repos.Clothes.SummerRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
import com.jeorgius.shop.repos.Electronics.LaptopRepo;
import com.jeorgius.shop.repos.Electronics.SmartphoneRepo;
import com.jeorgius.shop.repos.ItemRepo;
import com.jeorgius.shop.services.UpdateCommand.UpdateLaptop;
import com.jeorgius.shop.services.UpdateCommand.UpdateSmartphone;
import com.jeorgius.shop.services.UpdateCommand.UpdateSummer;
import com.jeorgius.shop.services.UpdateCommand.UpdateWinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateItem {

    private UpdateLaptop updateLaptop;
    private UpdateSmartphone updateSmartphone;
    private UpdateSummer updateSummer;
    private UpdateWinter updateWinter;

    @Autowired
    public UpdateItem(UpdateLaptop updateLaptop, UpdateSmartphone updateSmartphone, UpdateSummer updateSummer, UpdateWinter updateWinter) {
        this.updateLaptop = updateLaptop;
        this.updateSmartphone = updateSmartphone;
        this.updateSummer = updateSummer;
        this.updateWinter = updateWinter;
    }

    public void update(String sub, Integer itemId, Integer pQuantity){
        if (sub.equals("winter")) updateWinter.update(sub,itemId,pQuantity);
        if (sub.equals("summer")) updateSummer.update(sub,itemId,pQuantity);
        if (sub.equals("laptops")) updateLaptop.update(sub,itemId,pQuantity);
        if (sub.equals("smartphones")) updateSmartphone.update(sub,itemId,pQuantity);
    }
}
