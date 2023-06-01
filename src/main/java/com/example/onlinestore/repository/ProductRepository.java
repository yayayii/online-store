package com.example.onlinestore.repository;

import com.example.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository<T extends Product> extends JpaRepository<T, Long> {
}
