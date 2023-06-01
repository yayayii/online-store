package com.example.onlinestore.mapper;

import com.example.onlinestore.dto.request.product.LaptopRequestDto;
import com.example.onlinestore.dto.response.product.LaptopResponseDto;
import com.example.onlinestore.entity.product.Laptop;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LaptopMapper {
    public Laptop toEntity(LaptopRequestDto requestDto) {
        return new Laptop(
                requestDto.getSeries(),
                requestDto.getCompany(),
                requestDto.getPrice(),
                requestDto.getAmount(),
                requestDto.getScreenSize()
        );
    }

    public LaptopResponseDto toResponseDto(Laptop entity) {
        return new LaptopResponseDto(
                entity.getId(),
                entity.getSeries(),
                entity.getCompany(),
                entity.getPrice(),
                entity.getAmount(),
                entity.getScreenSize()
        );
    }
}
