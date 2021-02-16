package com.example.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.entity.EntityItem;
import com.example.item.repository.ItemRepo;
import com.example.item.utility.AppProperties;
import com.example.item.utility.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
public class Controller {
	@Autowired
	private ItemRepo rep;
	
	@Autowired 
	KafkaTemplate<String, EntityItem> kafkaTemplate;
	
	@Autowired
	private AppProperties ap;
	
	@PostMapping("/Item/save")
	@ApiOperation(value ="Save Item INFO", notes = "Saves Item details on database")
	public void saveData(@RequestBody EntityItem entity) {
		rep.save(entity);
		
	}

	@GetMapping("/Item/id/{id}")
	@ApiOperation(value ="Find Item By ID", notes = "Retrieves Item details from database")
	public EntityItem findByManagerId(@PathVariable("id")int id) {
		EntityItem item  = rep.findById(id).get();
		kafkaTemplate.send(ap.getFirst(), item);
		return item;
	}
	
	
	@GetMapping("/Item/getAll")
	@ApiOperation(value ="Find All Items", notes = "Retrieves Item details from database")
	public List<EntityItem> findALl() {
		List<EntityItem> items = rep.findAll();
		for(EntityItem i:items)
		{
			kafkaTemplate.send(ap.getFirst(), i);
		}
		return items;
	}

	@PutMapping("/Item/{id}/update")
	@ApiOperation(value ="Update Item Details", notes = "Update the details of Item")
	public String update(@PathVariable("id")int id, @RequestBody  EntityItem en) {
		try{
			if(rep.existsById(id)) {
				rep.save(en);
				return "Updated";
			}
			else {
				throw new ResourceNotFoundException("Item Not Found!");
			}
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@DeleteMapping("/Item/{id}/delete")
	@ApiOperation(value ="Delete the Item record", notes = "deletes the Item info from database")
	public String delete(@PathVariable("id") int id) {
		try {
			if(rep.existsById(id)) {
				rep.deleteById(id);
				return "Deleted";
			}
			else {
				throw new ResourceNotFoundException("Item Not Found!");
			}
			
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
	}
}
