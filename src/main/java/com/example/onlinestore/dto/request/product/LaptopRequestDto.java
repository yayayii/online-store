package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import com.example.onlinestore.util.validation.LaptopScreenSizeConstraint;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class LaptopRequestDto extends ProductRequestDto {
    @LaptopScreenSizeConstraint(groups = {Create.class, Update.class})
    private int screenSize;
}
