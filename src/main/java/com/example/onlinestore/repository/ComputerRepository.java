package com.example.onlinestore.repository;

import com.example.onlinestore.entity.product.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
