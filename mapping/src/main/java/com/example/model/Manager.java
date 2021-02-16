package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.model.Employee;
import com.sun.istack.NotNull;


@Entity
@Table(name = "ManagerTable")
public class Manager {
	@Id
	@Column(unique =true)
	private int id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String teamSize;

		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Employee.class)
	@JoinColumn(name = "empId",nullable = false)
	public Set<Employee> employee = new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTeamSize() {
		return teamSize;
	}


	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}


	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", teamSize=" + teamSize + ", employee=" + employee + "]";
	}


	public Set<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
			

}
