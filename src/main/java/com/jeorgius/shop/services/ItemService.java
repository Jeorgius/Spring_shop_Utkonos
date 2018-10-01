package com.jeorgius.shop.services;

import com.jeorgius.shop.entities.Item;
//import com.jeorgius.shop.repos.ItemBaseRepo;
import com.jeorgius.shop.entities.ItemCreds;
import com.jeorgius.shop.repos.ItemRepo;
import com.jeorgius.shop.services.ItemBuilder.ManageItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private ManageItems mi;

    @Autowired
    public ItemService(ManageItems mi) {
        this.mi = mi;
    }

    public void saveItem(ItemCreds itemCreds) {
        mi.addItem(itemCreds);
    }
    public Iterable renderPage(String page){
        return mi.renderPage(page);
    }
}
