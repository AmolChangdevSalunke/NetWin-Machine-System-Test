package com.mystore.My_Store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystore.My_Store.Model.Item;
import com.mystore.My_Store.Repositery.ItemRepository;
@Service
public class ItemService {
	@Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
