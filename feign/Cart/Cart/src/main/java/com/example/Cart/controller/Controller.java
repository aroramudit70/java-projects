package com.example.Cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cart.ItemClient;
import com.example.Cart.entity.EntityCart;
import com.example.Cart.entity.EntityItem;
import com.example.Cart.repository.CartRepo;
import com.example.Cart.utility.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
public class Controller {
	@Autowired
	private CartRepo rep;
	
	@Autowired
	private ItemClient client;
	
	
	@PostMapping("/Cart/save")
	@ApiOperation(value ="Save cart INFO", notes = "Saves Cart details on database")
	public void saveData(@RequestBody EntityCart entity) {
		rep.save(entity);
	}
	
	@GetMapping("/Cart/id/{id}")
	@ApiOperation(value ="Find Cart By ID", notes = "Retrieves Cart details from database")
	public EntityCart findByCartId(@PathVariable("id")int id) {
		return rep.findById(id).get();
	}
	@GetMapping("/Cart/getAll")
	@ApiOperation(value ="Find All Cart", notes = "Retrieves Cart details from database")
	public List<EntityCart> findALl() {
		System.out.println("Items present");
		for(EntityItem item : client.findAll()) {
			System.out.println(item.toString());
		}
		return rep.findAll();
		
	}

	@PutMapping("/Cart/{id}/update")
	@ApiOperation(value ="Update Cart Details", notes = "Update the details of Cart")
	public String update(@PathVariable("id")int id, @RequestBody  EntityCart en) {
		try{
			if(rep.existsById(id)) {
				rep.save(en);
				return "Updated";
			}
			else {
				throw new ResourceNotFoundException("Cart Not Found!");
			}
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@DeleteMapping("/Cart/{id}/delete")
	@ApiOperation(value ="Delete the Cart record", notes = "deletes the Cart info from database")
	public String delete(@PathVariable("id") int id) {
		try {
			if(rep.existsById(id)) {
				rep.deleteById(id);
				return "Deleted";
			}
			else {
				throw new ResourceNotFoundException("Cart Not Found!");
			}
			
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
	}
}
