package com.example.onlinestore.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LaptopResponseDto  {
    private Long id;
    private String series;
    private String company;
    private double price;
    private int amount;
    private int screenSize;
}
