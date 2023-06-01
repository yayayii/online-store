package com.example.onlinestore.entity;

import com.example.onlinestore.entity.enum_.FormFactor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Computer extends Product {
    private FormFactor formFactor;
}
