package com.mystore.My_Store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystore.My_Store.Model.Item;
import com.mystore.My_Store.Service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	 @Autowired
	    private ItemService itemService;

	    @GetMapping("/get")
	    public String getAllItems(Model model) {
	        model.addAttribute("items", itemService.getAllItems());
	        return "items";
	    }

	    @PostMapping("/create")
	    public String createItem(@ModelAttribute Item item) {
	        itemService.saveItem(item);
	        return "redirect:/items";
	    }

}
