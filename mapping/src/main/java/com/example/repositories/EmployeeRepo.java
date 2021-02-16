package com.example.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
