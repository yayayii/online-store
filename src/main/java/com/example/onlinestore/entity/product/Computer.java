package com.example.onlinestore.entity.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Computer extends Product {
    @Enumerated(value = EnumType.STRING)
    private FormFactor formFactor;


    public Computer(String series, String company, double price, int amount, FormFactor formFactor) {
        super(series, company, price, amount);
        this.formFactor = formFactor;
    }
}
