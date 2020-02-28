package com.cognizant.truyum.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface CartRepository extends JpaRepository<MenuItem, Long> {
 
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO cart (ct_us_id,ct_pr_id) values(?,?);", nativeQuery = true)
	Integer addToCart(long userId, long menuItemId);

	@Query(value = "SELECT me_id,me_name,me_price,me_active,me_date_of_launch,"
			+ "me_category,me_free_delivery,me_image_url FROM menu_item,cart "
			+ "WHERE ct_us_id=? AND me_id=ct_pr_id;", nativeQuery = true)
	List<MenuItem> getAllCartItems(long userId);
	
	@Query(value="SELECT SUM(m.me_price) FROM menu_item as m,cart as c where c.ct_us_id=? and m.me_id=c.ct_pr_id;",nativeQuery=true)
	Double getCartTotal(long userId);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM cart WHERE ct_us_id= ? AND ct_pr_id= ? LIMIT 1",nativeQuery=true)
	Integer removeCartItem(long userId,long menuItemId);

}
