package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComputerRequestDto {
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
    private FormFactor formFactor;
}
