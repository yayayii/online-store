package com.example.onlinestore.dto.response.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComputerResponseDto {
    private Long id;
    private String series;
    private String company;
    private double price;
    private int amount;
    private FormFactor formFactor;
}
