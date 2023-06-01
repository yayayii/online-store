package com.example.onlinestore.entity;

import com.example.onlinestore.entity.enum_.FormFactor;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Computer extends Product {
    private FormFactor formFactor;


    public Computer(String series, Company company, double price, int amount, FormFactor formFactor) {
        super(series, company, price, amount);
        this.formFactor = formFactor;
    }
}
