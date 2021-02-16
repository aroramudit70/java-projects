package com.example.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Cart.entity.EntityCart;


public interface CartRepo extends JpaRepository<EntityCart, Integer>{

}
