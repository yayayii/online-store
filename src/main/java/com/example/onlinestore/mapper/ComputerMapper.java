package com.example.onlinestore.mapper;

import com.example.onlinestore.dto.request.product.HddRequestDto;
import com.example.onlinestore.dto.response.product.HddResponseDto;
import com.example.onlinestore.entity.product.Hdd;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComputerMapper {
    public Hdd toEntity(HddRequestDto requestDto) {
        return new Hdd(
                requestDto.getSeries(),
                requestDto.getCompany(),
                requestDto.getPrice(),
                requestDto.getAmount(),
                requestDto.getStorageSize()
        );
    }

    public HddResponseDto toResponseDto(Hdd entity) {
        return new HddResponseDto(
                entity.getId(),
                entity.getSeries(),
                entity.getCompany(),
                entity.getPrice(),
                entity.getAmount(),
                entity.getStorageSize()
        );
    }
}
