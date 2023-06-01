package com.example.onlinestore.entity.product;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Hdd extends Product {
    private double storageSize;


    public Hdd(String series, String company, double price, int amount, double storageSize) {
        super(series, company, price, amount);
        this.storageSize = storageSize;
    }
}
