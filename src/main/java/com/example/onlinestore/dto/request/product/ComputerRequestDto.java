package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class ComputerRequestDto extends ProductRequestDto {
    @NotNull(groups = {Create.class, Update.class})
    private FormFactor formFactor;


    public ComputerRequestDto(Long id, String series, String company, double price, int amount, FormFactor formFactor) {
        super(id, series, company, price, amount);
        this.formFactor = formFactor;
    }
}
