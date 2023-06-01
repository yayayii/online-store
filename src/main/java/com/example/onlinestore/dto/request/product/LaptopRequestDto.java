package com.example.onlinestore.dto.request.product;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class LaptopRequestDto extends ProductRequestDto {
    @NotNull
    private int screenSize;


    public LaptopRequestDto(String series, String company, double price, int amount, int screenSize) {
        super(series, company, price, amount);
        this.screenSize = screenSize;
    }
}