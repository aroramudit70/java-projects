package com.example.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class EntityItem {
	@Id
	private int itemNo;
	
	@Column
	private double price;
	
	@Column
	private int quantityInGms;
	
	@Column
	private String name;
	public EntityItem() {
		
	}
	public EntityItem(int itemNo, double price, int quantityInGms, String name) {
		super();
		this.itemNo = itemNo;
		this.price = price;
		this.quantityInGms = quantityInGms;
		this.name = name;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityInGms() {
		return quantityInGms;
	}

	public void setQuantityInGms(int quantityInGms) {
		this.quantityInGms = quantityInGms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EntityItem [itemNo=" + itemNo + ", price=" + price + ", quantityInGms=" + quantityInGms + ", name="
				+ name + "]";
	}
}
