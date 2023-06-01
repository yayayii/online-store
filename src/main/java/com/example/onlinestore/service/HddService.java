package com.example.onlinestore.service;

import com.example.onlinestore.dto.request.product.HddRequestDto;
import com.example.onlinestore.dto.response.product.HddResponseDto;
import com.example.onlinestore.entity.product.Hdd;
import com.example.onlinestore.mapper.HddMapper;
import com.example.onlinestore.repository.ProductRepository;
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
    private final ProductRepository<Hdd> repository;


    @Transactional
    public HddResponseDto addHdd(HddRequestDto requestDto) {
        log.info("HddService-addHdd. Recieved: {}", requestDto);

        Hdd hdd = HddMapper.toEntity(requestDto);
        HddResponseDto responseDto = HddMapper.toResponseDto(repository.save(hdd));

        log.info("HddService-addHdd. Sending: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public HddResponseDto updateHdd(Long hddId, HddRequestDto requestDto) {
        log.info("HddService-updateHdd. Recieved: {}; {}", hddId, requestDto);

        Hdd hdd = repository.findById(hddId)
                .orElseThrow(() -> new NoSuchElementException("HDD id = " + hddId + " doesn't exist"));
        hdd.setSeries(requestDto.getSeries());
        hdd.setCompany(requestDto.getCompany());
        hdd.setPrice(requestDto.getPrice());
        hdd.setAmount(requestDto.getAmount());
        hdd.setStorageSize(requestDto.getStorageSize());
        HddResponseDto responseDto = HddMapper.toResponseDto(hdd);

        log.info("HddService-updateHdd. Sending: {}", responseDto);
        return responseDto;
    }

    public HddResponseDto getHddById(Long hddId) {
        log.info("HddService-getHddById. Recieved: {}", hddId);

        Hdd hdd = repository.findById(hddId)
                .orElseThrow(() -> new NoSuchElementException("HDD id = " + hddId + " doesn't exist"));
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
