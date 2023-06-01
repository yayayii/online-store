package com.example.onlinestore.dto.response.product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class LaptopResponseDto extends ProductResponseDto {
    private int screenSize;


    public LaptopResponseDto(Long id, String series, String company, double price, int amount, int screenSize) {
        super(id, series, company, price, amount);
        this.screenSize = screenSize;
    }
}
