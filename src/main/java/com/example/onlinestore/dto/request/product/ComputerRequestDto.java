package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.entity.product.enum_.FormFactor;
import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import lombok.*;

import javax.validation.constraints.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class ComputerRequestDto extends ProductRequestDto {
    @NotNull(groups = {Create.class, Update.class})
    private FormFactor formFactor;
}
