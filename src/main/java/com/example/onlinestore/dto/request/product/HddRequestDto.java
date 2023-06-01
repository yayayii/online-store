package com.example.onlinestore.dto.request.product;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class HddRequestDto extends ProductRequestDto {
    @NotNull
    private double storageSize;


    public HddRequestDto(String series, String company, double price, int amount, double storageSize) {
        super(series, company, price, amount);
        this.storageSize = storageSize;
    }
}
