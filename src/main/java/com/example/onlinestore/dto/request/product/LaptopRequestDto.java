package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import com.example.onlinestore.util.validation.LaptopScreenSizeConstraint;
import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class LaptopRequestDto extends ProductRequestDto {
    @LaptopScreenSizeConstraint(groups = {Create.class, Update.class})
    private int screenSize;


    public LaptopRequestDto(Long id, String series, String company, double price, int amount, int screenSize) {
        super(id, series, company, price, amount);
        this.screenSize = screenSize;
    }
}
