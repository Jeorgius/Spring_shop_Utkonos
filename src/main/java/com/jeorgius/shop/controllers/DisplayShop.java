package com.jeorgius.shop.controllers;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.entities.clothes.Clothes;
import com.jeorgius.shop.entities.clothes.SummerClothes;
import com.jeorgius.shop.repos.Clothes.ClothesRepo;
//import com.jeorgius.shop.repos.ItemBaseRepo;
import com.jeorgius.shop.repos.Clothes.SummerRepo;
import com.jeorgius.shop.repos.Clothes.WinterRepo;
import com.jeorgius.shop.repos.ItemRepo;
import com.jeorgius.shop.services.ItemService;
import com.jeorgius.shop.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class DisplayShop {

    private ValidationService validationService;
    private ItemService itemService;

    @Autowired
    public DisplayShop(ValidationService validationService, ItemService itemService) {
        this.validationService = validationService;
        this.itemService = itemService;
    }

    @RequestMapping("/")
    public String shop(Model model){
        return "shop";
    }

    @GetMapping("/add")
    public String add(Model model){
        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title,
                      @RequestParam String subcategory,
                      @RequestParam String quantity,
                      @RequestParam String price,
                      Model model){
        Integer q = Integer.parseInt(quantity);
        Integer p = Integer.parseInt(price);

        ItemCreds itemCreds = new ItemCreds()
                                  .setCategory(validationService.getCategory(subcategory))
                                  .setSubcategory(subcategory)
                                  .setTitle(title)
                                  .setPrice(p)
                                  .setQuantity(q);
        itemService.saveItem(itemCreds);
        return "add";
    }

    @GetMapping("/clothes")
    public String clothes(Model model){
        model.addAttribute("items", itemService.renderPage("clothes"));
        return "clothes";
    }
    @GetMapping("/clothes/summer")
    public String summer(Model model){
        model.addAttribute("items", itemService.renderPage("summer"));
        return "summerclothes";
    }
    @GetMapping("/clothes/winter")
    public String winter(Model model){
        model.addAttribute("items", itemService.renderPage("winter"));
        return "winterclothes";
    }

    @GetMapping("/electronics")
    public String electronics(Model model){
        model.addAttribute("items", itemService.renderPage("electronics"));
        return "electronics";
    }
    @GetMapping("/electronics/smartphones")
    public String smartphones(Model model){
        model.addAttribute("items", itemService.renderPage("smartphones"));
        return "smartphones";
    }
    @GetMapping("/electronics/laptops")
    public String laptops(Model model){
        model.addAttribute("items", itemService.renderPage("laptops"));
        return "laptops";
    }
}
