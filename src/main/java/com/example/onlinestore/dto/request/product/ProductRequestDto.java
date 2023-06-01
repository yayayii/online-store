package com.example.onlinestore.dto.request.product;

import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProductRequestDto {
    @NotNull(groups = Update.class)
    private Long id;
    @NotBlank(groups = {Create.class, Update.class}) @Size(max = 50, groups = {Create.class, Update.class})
    private String series;
    @NotBlank(groups = {Create.class, Update.class})
    private String company;
    @Positive(groups = {Create.class, Update.class})
    private double price;
    @PositiveOrZero(groups = {Create.class, Update.class})
    private int amount;
}
