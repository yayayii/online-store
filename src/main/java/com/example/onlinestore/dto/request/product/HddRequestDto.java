package com.example.onlinestore.dto.request.product;

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
public class HddRequestDto extends ProductRequestDto {
    @Positive(groups = {Create.class, Update.class})
    private double storageSize;


    public HddRequestDto(Long id, String series,  String company, double price, int amount, double storageSize) {
        super(id, series, company, price, amount);
        this.storageSize = storageSize;
    }
}
