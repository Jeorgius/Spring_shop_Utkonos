package com.jeorgius.shop.repos.Clothes;

import com.jeorgius.shop.entities.clothes.SummerClothes;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SummerRepo extends ClothesRepo<SummerClothes> {
    List<SummerClothes> findAllBySubcategory(String s);
    SummerClothes findOneById(Integer i);
}
