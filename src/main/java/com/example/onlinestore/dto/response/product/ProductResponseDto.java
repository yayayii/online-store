package com.example.onlinestore.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductResponseDto {
    private Long id;
    private String series;
    private String company;
    private double price;
    private int amount;
}
