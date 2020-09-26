package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemRepository.FilterItemsForCustomer();
	}


	public List<MenuItem> getMenuItemListAdmin() {;
		return menuItemRepository.findAll();
	}


	public MenuItem getMenuItem(Long id) {
		return menuItemRepository.findById(id).get();
	}


	public boolean modifyMenuItem(MenuItem menuItem) {
		Optional<MenuItem> opMenuItem = menuItemRepository.findById(menuItem.getId());
		if(opMenuItem.isPresent()) {
			menuItemRepository.save(menuItem);
			return true;
		}
		else
			return false;
	}

}
