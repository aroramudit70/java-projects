package com.example.Cart;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Cart.entity.EntityItem;

@FeignClient(name="CartItemMicroservice")
public interface ItemClient {
	
//	@GetMapping("/Item/id/{id}")
//	public String findItemByItem(@PathVariable("id")int id) ;
//	
//	@GetMapping("/Item/getAll")
//	public List<String> findAll();
	
	@GetMapping("/Item/id/{id}")
	public EntityItem findItemByItem(@PathVariable("id")int id) ;
	
	@GetMapping("/Item/getAll")
	public List<EntityItem> findAll();
	
}
