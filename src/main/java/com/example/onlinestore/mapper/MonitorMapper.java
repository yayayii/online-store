package com.example.onlinestore.mapper;

import com.example.onlinestore.dto.request.product.MonitorRequestDto;
import com.example.onlinestore.dto.response.product.MonitorResponseDto;
import com.example.onlinestore.entity.product.Monitor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MonitorMapper {
    public Monitor toEntity(MonitorRequestDto requestDto) {
        return new Monitor(
                requestDto.getSeries(),
                requestDto.getCompany(),
                requestDto.getPrice(),
                requestDto.getAmount(),
                requestDto.getScreenSize()
        );
    }

    public MonitorResponseDto toResponseDto(Monitor entity) {
        return new MonitorResponseDto(
                entity.getId(),
                entity.getSeries(),
                entity.getCompany(),
                entity.getPrice(),
                entity.getAmount(),
                entity.getScreenSize()
        );
    }
}
