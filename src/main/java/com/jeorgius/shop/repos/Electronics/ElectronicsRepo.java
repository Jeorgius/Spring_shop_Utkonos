package com.jeorgius.shop.repos.Electronics;

import com.jeorgius.shop.entities.Item;
import com.jeorgius.shop.entities.electronics.Electronics;
import com.jeorgius.shop.repos.ItemRepo;

import javax.transaction.Transactional;

@Transactional
public interface ElectronicsRepo<T extends Item> extends ItemRepo<Electronics> {}
