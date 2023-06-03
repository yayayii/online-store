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
public class MonitorRequestDto extends ProductRequestDto {
    @Positive(groups = {Create.class, Update.class})
    private int screenSize;


    public MonitorRequestDto(Long id, String series, String company, double price, int amount, int screenSize) {
        super(id, series, company, price, amount);
        this.screenSize = screenSize;
    }
}
