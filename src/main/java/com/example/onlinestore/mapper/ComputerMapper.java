package com.example.onlinestore.mapper;

import com.example.onlinestore.dto.request.product.ComputerRequestDto;
import com.example.onlinestore.dto.response.product.ComputerResponseDto;
import com.example.onlinestore.entity.product.Computer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComputerMapper {
    public Computer toEntity(ComputerRequestDto requestDto) {
        return new Computer(
                requestDto.getSeries(),
                requestDto.getCompany(),
                requestDto.getPrice(),
                requestDto.getAmount(),
                requestDto.getFormFactor()
        );
    }

    public ComputerResponseDto toResponseDto(Computer entity) {
        return new ComputerResponseDto(
                entity.getId(),
                entity.getSeries(),
                entity.getCompany(),
                entity.getPrice(),
                entity.getAmount(),
                entity.getFormFactor()
        );
    }
}
