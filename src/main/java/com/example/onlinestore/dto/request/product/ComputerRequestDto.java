package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class ComputerRequestDto extends ProductRequestDto {
    @NotNull
    private FormFactor formFactor;


    public ComputerRequestDto(String series, String company, double price, int amount, FormFactor formFactor) {
        super(series, company, price, amount);
        this.formFactor = formFactor;
    }
}
