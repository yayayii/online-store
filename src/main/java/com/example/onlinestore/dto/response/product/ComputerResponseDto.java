package com.example.onlinestore.dto.response.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class ComputerResponseDto extends ProductResponseDto {
    private FormFactor formFactor;


    public ComputerResponseDto(
            Long id, String series, String company, double price, int amount, FormFactor formFactor
    ) {
        super(id, series, company, price, amount);
        this.formFactor = formFactor;
    }
}
