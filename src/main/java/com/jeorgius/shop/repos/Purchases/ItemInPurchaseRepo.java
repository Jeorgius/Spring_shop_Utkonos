package com.jeorgius.shop.repos.Purchases;

import com.jeorgius.shop.entities.orders.ItemInPurchase;
import com.jeorgius.shop.entities.orders.Purchase;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ItemInPurchaseRepo extends CrudRepository<ItemInPurchase, Integer> {
    List<ItemInPurchase> findAll();
    List<ItemInPurchase> findByPurchase(Purchase purchase);
}
