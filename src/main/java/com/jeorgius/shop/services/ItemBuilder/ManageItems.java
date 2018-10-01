package com.jeorgius.shop.services.ItemBuilder;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;
//import com.jeorgius.shop.repos.Clothes.SummerRepo;
//import com.jeorgius.shop.repos.Clothes.WinterRepo;
//import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
//import com.jeorgius.shop.repos.Electronics.LaptopRepo;
//import com.jeorgius.shop.repos.Electronics.SmartphoneRepo;
import com.jeorgius.shop.entities.clothes.SummerClothes;
import com.jeorgius.shop.entities.clothes.WinterClothes;
import com.jeorgius.shop.entities.electronics.Electronics;
import com.jeorgius.shop.entities.electronics.Laptop;
import com.jeorgius.shop.entities.electronics.Smartphone;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
import com.jeorgius.shop.repos.Clothes.SummerRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.Electronics.ElectronicsRepo;
import com.jeorgius.shop.repos.Electronics.LaptopRepo;
import com.jeorgius.shop.repos.Electronics.SmartphoneRepo;
import com.jeorgius.shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ManageItems implements ItemSaveCommand {

    private ItemCreds itemCreds;

    private ClothesRepo clothesRepo;
    private ElectronicsRepo electronicsRepo;
    private SummerRepo summerRepo;
    private WinterRepo winterRepo;
    private SmartphoneRepo smartphoneRepo;
    private LaptopRepo laptopRepo;
    private ItemRepo itemRepo;

    @Autowired
    public ManageItems(ClothesRepo clothesRepo, ElectronicsRepo electronicsRepo, SummerRepo summerRepo, WinterRepo winterRepo, SmartphoneRepo smartphoneRepo, LaptopRepo laptopRepo, ItemRepo itemRepo) {
        this.clothesRepo = clothesRepo;
        this.electronicsRepo = electronicsRepo;
        this.summerRepo = summerRepo;
        this.winterRepo = winterRepo;
        this.smartphoneRepo = smartphoneRepo;
        this.laptopRepo = laptopRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public void addItem(ItemCreds ic) {
        if(ic.getSubcategory().equals("summer")) summerRepo.save(new SummerClothes(ic));
        if(ic.getSubcategory().equals("winter")) winterRepo.save(new WinterClothes(ic));
        if(ic.getSubcategory().equals("smartphones")) smartphoneRepo.save(new Smartphone(ic));
        if(ic.getSubcategory().equals("laptops")) laptopRepo.save(new Laptop(ic));
    }

    public Iterable renderPage(String toRender){
        if (toRender.equals("clothes")) return clothesRepo.findAll();
        if (toRender.equals("electronics")) return electronicsRepo.findAll();
        if (toRender.equals("winter")) return winterRepo.findAllBySubcategory("winter");
        if (toRender.equals("summer")) return summerRepo.findAllBySubcategory("summer");
        if (toRender.equals("smartphones")) return smartphoneRepo.findAllBySubcategory("smartphones");
        if (toRender.equals("laptops")) return laptopRepo.findAllBySubcategory("laptops");
        else return clothesRepo.findAll();
    }

    public Item findItem(String subcategory, Integer id){
        if (subcategory.equals("winter")) return winterRepo.findOneById(id);
        if (subcategory.equals("summer")) return summerRepo.findOneById(id);
        if (subcategory.equals("smartphones")) return smartphoneRepo.findOneById(id);
        if (subcategory.equals("laptops")) return laptopRepo.findOneById(id);
        else return itemRepo.findOneById(id);
    }

//    public void update(Object item){
//        if (item instanceof WinterClothes) winterRepo.save(item);
//        if (item instanceof SummerClothes) summerRepo.save(item);
//        if (subcategory.equals("smartphones")) smartphoneRepo.findOneById(id);
//        if (subcategory.equals("laptops")) laptopRepo.findOneById(id);
//        else itemRepo.findOneById(id);
//    }
}
