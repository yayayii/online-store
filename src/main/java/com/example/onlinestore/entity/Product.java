package com.example.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Product {
    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String series;
    @ManyToOne
    private Company company;
    private double price;
    private int amount;


    public Product(String series, Company company, double price, int amount) {
        this.series = series;
        this.company = company;
        this.price = price;
        this.amount = amount;
    }
}
