package com.example.onlinestore.service;

import com.example.onlinestore.dto.request.product.LaptopRequestDto;
import com.example.onlinestore.dto.response.product.LaptopResponseDto;
import com.example.onlinestore.entity.product.Laptop;
import com.example.onlinestore.mapper.LaptopMapper;
import com.example.onlinestore.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
@Service
public class LaptopService {
    private final LaptopRepository repository;


    @Transactional
    public LaptopResponseDto createLaptop(LaptopRequestDto requestDto) {
        log.info("LaptopService-createLaptop. Recieved: {}", requestDto);

        Laptop laptop = LaptopMapper.toEntity(requestDto);
        LaptopResponseDto responseDto = LaptopMapper.toResponseDto(repository.save(laptop));

        log.info("LaptopService-createLaptop. Sending: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public LaptopResponseDto updateLaptop(LaptopRequestDto requestDto) {
        log.info("LaptopService-updateLaptop. Recieved: {}", requestDto);

        Laptop laptop = repository.findById(requestDto.getId())
                .orElseThrow(() -> new NoSuchElementException("Laptop id = " + requestDto.getId() + " doesn't exist"));
        laptop.setSeries(requestDto.getSeries());
        laptop.setCompany(requestDto.getCompany());
        laptop.setPrice(requestDto.getPrice());
        laptop.setAmount(requestDto.getAmount());
        laptop.setScreenSize(requestDto.getScreenSize());
        LaptopResponseDto responseDto = LaptopMapper.toResponseDto(laptop);

        log.info("LaptopService-updateLaptop. Sending: {}", responseDto);
        return responseDto;
    }

    public LaptopResponseDto getLaptopById(Long id) {
        log.info("LaptopService-getLaptopById. Recieved: {}", id);

        Laptop laptop = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Laptop id = " + id + " doesn't exist"));
        LaptopResponseDto responseDto = LaptopMapper.toResponseDto(laptop);

        log.info("LaptopService-getLaptopById. Sending: {}", responseDto);
        return responseDto;
    }

    public List<LaptopResponseDto> getAllLaptops() {
        log.info("LaptopService-getAllLaptops");

        List<LaptopResponseDto> laptops = repository.findAll().stream()
                .map(LaptopMapper::toResponseDto).collect(Collectors.toList());

        log.info("LaptopService-getAllLaptops. Sending: {}", laptops);
        return laptops;
    }
}
