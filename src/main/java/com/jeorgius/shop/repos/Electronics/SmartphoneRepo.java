package com.jeorgius.shop.repos.Electronics;


import com.jeorgius.shop.entities.electronics.Laptop;
import com.jeorgius.shop.entities.electronics.Smartphone;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SmartphoneRepo extends ElectronicsRepo<Smartphone> {
    public List<Smartphone> findAllBySubcategory(String s);
    Smartphone findOneById(Integer i);
}
