package com.mystore.My_Store.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mystore.My_Store.Model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
