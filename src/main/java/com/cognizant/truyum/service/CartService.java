package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.Item;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

	/*
	 * @Autowired cartDao cartDao;
	 */

	@Autowired
	UserRepository userRepository;

	@Autowired
	MenuItemRepository menuItemRepository;

	@Autowired
	CartRepository cartRepository;

	public boolean addCartItem(String username, Item item) {
		User user = userRepository.findByUsername(username);
		MenuItem menuItem = menuItemRepository.getOne(item.getItem().getId());
		Cart cart
		user.getCart().add();
		userRepository.save(user);
		return true;
	}

	public CartDTO getAllCartItems(String username) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartItems(userRepository.getMenuItems(username));
		try {
			cartDTO.setTotal(cartRepository.getCartTotal(userRepository.findByUsername(username).getId()));
		} catch (NullPointerException e) {
			cartDTO.setTotal(0);
		}
		return cartDTO;
	}

	public CartDTO deleteCartItem(String username, Long menuItemId) {
		User user = userRepository.findByUsername(username);
		List<MenuItem> userMenuItemList = user.getMenuItems();
		userMenuItemList.removeIf(mItem -> {
			return mItem.getId() == menuItemId;
		});
		double total = userMenuItemList.stream().map(m -> m.getPrice()).reduce(0f, (a, b) -> a + b);
		user.setMenuItems(userMenuItemList);
		userRepository.save(user);
		return new CartDTO(userMenuItemList,total);
	}
}
