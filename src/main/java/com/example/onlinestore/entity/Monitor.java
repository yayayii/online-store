package com.example.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Monitor extends Product {
    private int screenSize;


    public Monitor(String series, Company company, double price, int amount, int screenSize) {
        super(series, company, price, amount);
        this.screenSize = screenSize;
    }
}
