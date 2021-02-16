package com.example.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.item.entity.EntityItem;



public interface ItemRepo extends JpaRepository<EntityItem, Integer> {

}
