package com.jeorgius.shop.repos.Clothes;


import com.jeorgius.shop.entities.clothes.WinterClothes;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WinterRepo extends ClothesRepo<WinterClothes> {
    List<WinterClothes> findAllBySubcategory(String s);
    WinterClothes findOneById(Integer i);
}
