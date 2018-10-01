package com.jeorgius.shop.repos.Clothes;

import com.jeorgius.shop.entities.clothes.Clothes;
import com.jeorgius.shop.repos.ItemRepo;
import javax.transaction.Transactional;

@Transactional
public interface ClothesRepo<T extends Clothes> extends ItemRepo<Clothes> {}
