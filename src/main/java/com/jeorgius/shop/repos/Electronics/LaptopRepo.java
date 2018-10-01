package com.jeorgius.shop.repos.Electronics;

import com.jeorgius.shop.entities.electronics.Laptop;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LaptopRepo extends ElectronicsRepo<Laptop> {
    public List<Laptop> findAllBySubcategory(String s);
    Laptop findOneById(Integer i);
}
