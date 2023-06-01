package com.example.onlinestore.dto.request.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class ProductRequestDto {
    private String series;
    private String company;
    private double price;
    private int amount;


    public ProductRequestDto(
            @NotBlank @Size(max = 50) String series,
            @NotNull String company,
            @NotNull double price,
            @NotNull int amount
    ) {
        this.series = series;
        this.company = company;
        this.price = price;
        this.amount = amount;
    }
}
