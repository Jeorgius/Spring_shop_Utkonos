package com.jeorgius.shop.services.ItemBuilder;

import com.jeorgius.shop.entities.ItemCreds;

public interface ItemSaveCommand {

    void addItem(ItemCreds itemCreds);
}
