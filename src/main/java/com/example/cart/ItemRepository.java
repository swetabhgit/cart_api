package com.example.cart;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cart.model.Item;

public interface ItemRepository extends JpaRepository<Item, String>{

}
