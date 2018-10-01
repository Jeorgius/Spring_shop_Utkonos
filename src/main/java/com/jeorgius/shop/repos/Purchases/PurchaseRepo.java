package com.jeorgius.shop.repos.Purchases;

import com.jeorgius.shop.entities.orders.Purchase;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PurchaseRepo extends CrudRepository<Purchase, Integer> {
    Purchase findFirstByOrderByIdDesc();
}
