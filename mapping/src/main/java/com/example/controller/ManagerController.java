package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.Manager;
import com.example.repositories.EmployeeRepo;
import com.example.repositories.ManagerRepo;
import com.example.utility.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
public class ManagerController {
	@Autowired
	private ManagerRepo rep;
	
	@Autowired
	private EmployeeRepo repo;
	@PostMapping("/Manager/save")
	@ApiOperation(value ="Save Manager INFO", notes = "Saves manager details on database")
	public void saveData(@RequestBody Manager entity) {
		rep.save(entity);
		
	}
	
	@GetMapping("/Manager/id/{id}")
	@ApiOperation(value ="Find Manager By ID", notes = "Retrieves manager details from database")
	public Optional<Manager> findByManagerId(@PathVariable("id")int id) {
		Optional<Manager> res = rep.findById(id);
		return res;
	}

	@PutMapping("/Manager/{id}/update")
	@ApiOperation(value ="Update Manager Details", notes = "Update the details of manager")
	public String update(@PathVariable("id")int id, @RequestBody  Manager en) {
		try{
			if(rep.existsById(id)) {
				rep.save(en);
				return "Updated";
			}
			else {
				throw new ResourceNotFoundException("Manager Not Found!");
			}
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@DeleteMapping("/Manager/{id}/delete")
	@ApiOperation(value ="Delete the Manager record", notes = "deletes the manager info from database")
	public String delete(@PathVariable("id") int id) {
		try {
			if(rep.existsById(id)) {
				rep.deleteById(id);
				return "Deleted";
			}
			else {
				throw new ResourceNotFoundException("Manager Not Found!");
			}
			
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
	}
	
	@DeleteMapping("/Manager/{id}/delete-employee/{cid}")
	@ApiOperation(value ="Delete the Employee record", notes = "deletes the Employee info from database")
	public String deleteEmployee(@PathVariable("id") int id, @PathVariable("cid") int cid) {
		try {
			if(rep.existsById(id)) {
				Manager man = rep.findById(id).get();
				for(Employee e: man.getEmployee()) {
					if(e.getCust_id()==cid) {
						man.getEmployee().remove(e);
						repo.deleteById(cid);
						return "Deleted";
					}
					
				}
			
				throw new ResourceNotFoundException("Employee Not Found!");
				
			}
			else {
				throw new ResourceNotFoundException("Manager Not Found!");
			}
			
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
	}
		@PostMapping("/Manager/{id}/add-employee/{cid}")
		@ApiOperation(value ="Add the Employee record", notes = "ADD the Employee info from database")
		public void AddEmployee(@PathVariable("id") int id, @RequestBody Employee en) {
			try {
				if(rep.existsById(id)) {
					Manager m=rep.findById(id).get();
					m.getEmployee().add(en);
					rep.save(m);
					repo.save(en);
				}
				else {
					throw new ResourceNotFoundException("Manager Not Found!");
				}
				
			} catch (ResourceNotFoundException e) {
				 System.out.println(e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
}
