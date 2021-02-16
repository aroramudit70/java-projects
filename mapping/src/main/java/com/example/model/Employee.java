package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Employee")
public class Employee{

	@Id
	@Column(unique =true)
	private int cust_id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String designation;
	
	@Column
	private double rating;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Manager.class)
//	@JoinColumn(name = "manager_id",nullable = false)
//	@JsonIgnore
//	private Manager manager;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

//	public Manager getManager() {
//		return manager;
//	}
//
//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}

	
}
