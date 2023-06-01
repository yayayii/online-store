package com.example.onlinestore.dto.request.product;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HddRequestDto {
    @NotBlank
    @Size(max = 50)
    private String series;
    @NotNull
    private String company;
    @NotNull
    private double price;
    @NotNull
    private int amount;
    @NotNull
    private double storageSize;
}
