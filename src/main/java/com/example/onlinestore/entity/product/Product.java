package com.example.onlinestore.entity.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@MappedSuperclass
public class Product {
    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String series;
    private String company;
    private double price;
    private int amount;


    public Product(String series, String company, double price, int amount) {
        this.series = series;
        this.company = company;
        this.price = price;
        this.amount = amount;
    }
}
