package com.example.onlinestore.service;

import com.example.onlinestore.dto.request.product.HddRequestDto;
import com.example.onlinestore.dto.response.product.HddResponseDto;
import com.example.onlinestore.entity.product.Hdd;
import com.example.onlinestore.mapper.HddMapper;
import com.example.onlinestore.repository.HddRepository;
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
public class HddService {
    private final HddRepository repository;


    @Transactional
    public HddResponseDto createHdd(HddRequestDto requestDto) {
        log.info("HddService-createHdd. Recieved: {}", requestDto);

        Hdd hdd = HddMapper.toEntity(requestDto);
        HddResponseDto responseDto = HddMapper.toResponseDto(repository.save(hdd));

        log.info("HddService-createHdd. Sending: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public HddResponseDto updateHdd(HddRequestDto requestDto) {
        log.info("HddService-updateHdd. Recieved: {}", requestDto);

        Hdd hdd = repository.findById(requestDto.getId())
                .orElseThrow(() -> new NoSuchElementException("HDD id = " + requestDto.getId() + " doesn't exist"));
        hdd.setSeries(requestDto.getSeries());
        hdd.setCompany(requestDto.getCompany());
        hdd.setPrice(requestDto.getPrice());
        hdd.setAmount(requestDto.getAmount());
        hdd.setStorageSize(requestDto.getStorageSize());
        HddResponseDto responseDto = HddMapper.toResponseDto(hdd);

        log.info("HddService-updateHdd. Sending: {}", responseDto);
        return responseDto;
    }

    public HddResponseDto getHddById(Long id) {
        log.info("HddService-getHddById. Recieved: {}", id);

        Hdd hdd = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("HDD id = " + id + " doesn't exist"));
        HddResponseDto responseDto = HddMapper.toResponseDto(hdd);

        log.info("HddService-getHddById. Sending: {}", responseDto);
        return responseDto;
    }

    public List<HddResponseDto> getAllHdds() {
        log.info("HddService-getAllHdds");

        List<HddResponseDto> hdds = repository.findAll().stream()
                .map(HddMapper::toResponseDto).collect(Collectors.toList());

        log.info("HddService-getAllHdds. Sending: {}", hdds);
        return hdds;
    }
}
