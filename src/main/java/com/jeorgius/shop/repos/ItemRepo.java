package com.jeorgius.shop.repos;

import com.jeorgius.shop.entities.Item;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
//public interface ItemRepo<T extends Item> extends ItemBaseRepo<Item> {
////    List<Item> findByCategory(String category);
////}
public interface ItemRepo<T extends Item> extends CrudRepository<T, Integer>{
    Item findOneById(Integer id);
}
