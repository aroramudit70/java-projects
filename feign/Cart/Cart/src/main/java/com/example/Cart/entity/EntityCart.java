package com.example.Cart.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class EntityCart {
	public EntityCart() {
		
	}
	public EntityCart(int cartNo, int cartSize) {
		super();
		this.cartNo = cartNo;
		this.cartSize = cartSize;
	}

	@Id
	private int cartNo;
	
	@Column
	private int cartSize;
	

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}


	@Override
	public String toString() {
		return "EntityCart [cartNo=" + cartNo + ", cartSize=" + cartSize + "]";
	}

}
