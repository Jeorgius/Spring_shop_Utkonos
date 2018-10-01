package com.jeorgius.shop.repos.Purchases;

import com.jeorgius.shop.entities.orders.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepo extends CrudRepository<UserAddress, Integer> {

    UserAddress findOneById(Integer i);
}
