package com.example.onlinestore.dto.response.product;

import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class HddResponseDto extends ProductResponseDto {
    private double storageSize;


    public HddResponseDto(Long id, String series, String company, double price, int amount, double storageSize) {
        super(id, series, company, price, amount);
        this.storageSize = storageSize;
    }
}
