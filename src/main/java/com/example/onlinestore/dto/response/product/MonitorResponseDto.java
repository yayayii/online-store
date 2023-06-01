package com.example.onlinestore.dto.response.product;

import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class MonitorResponseDto extends ProductResponseDto {
    private int screenSize;


    public MonitorResponseDto(Long id, String series, String company, double price, int amount, int screenSize) {
        super(id, series, company, price, amount);
        this.screenSize = screenSize;
    }
}
