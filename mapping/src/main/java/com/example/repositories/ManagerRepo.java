package com.example.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
