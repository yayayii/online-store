package com.example.onlinestore.repository;

import com.example.onlinestore.entity.product.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
